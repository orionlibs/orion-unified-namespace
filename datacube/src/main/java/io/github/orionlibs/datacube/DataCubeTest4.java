package io.github.orionlibs.datacube;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.reader.TextLineInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.CloseableIterator;

public class DataCubeTest4
{
    public static void main(String[] args)
    {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.BATCH);
        String path = "D:/temp/sample2.csv";
        FileSource<String> source = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path(path)).build();
        DataStream<String> rawStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "CSVFile1");
        DataStream<SpotlightDataRow> recordStream = rawStream.filter(line -> !line.startsWith(",FinancialYear"))
                        .map(line -> {
                            SpotlightDataRow csvRow = new SpotlightDataRow();
                            String[] fields = line.split(",");
                            csvRow.empty = fields[0];
                            csvRow.financialYear = fields[1];
                            csvRow.opExCategory = fields[2];
                            csvRow.emsLevel1 = fields[3];
                            csvRow.emsLevel2 = fields[4];
                            csvRow.emsLevel3 = fields[5];
                            csvRow.emsLevel4 = fields[6];
                            csvRow.company = fields[7];
                            csvRow.movement = Double.parseDouble(fields[8]);
                            csvRow.backDatedJournals = Double.parseDouble(fields[9]);
                            csvRow.backDatedJournalLinesDebitValue = Double.parseDouble(fields[10]);
                            return csvRow;
                        })
                        .returns(TypeInformation.of(SpotlightDataRow.class));
        recordStream = recordStream.filter(x -> x.movement != null);
        KeyedStream<SpotlightDataRow, String> keyedStream = recordStream.keyBy(record -> record.opExCategory);
        SingleOutputStreamOperator<SpotlightDataRow> aggregatedStream = keyedStream.reduce((row1, row2) -> {
            row1.movement += row2.movement;
            return row1;
        });
        try(CloseableIterator<SpotlightDataRow> resultIterator = aggregatedStream.executeAndCollect())
        {
            while(resultIterator.hasNext())
            {
                System.out.println(resultIterator.next());
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

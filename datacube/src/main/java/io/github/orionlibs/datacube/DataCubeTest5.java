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

public class DataCubeTest5
{
    public static void main(String[] args)
    {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.BATCH);
        String path = "D:/temp/sample3.csv";
        FileSource<String> source = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path(path)).build();
        DataStream<String> rawStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "CSVFile1");
        DataStream<SpotlightDataRow> recordStream = rawStream.filter(line -> !line.startsWith(",FinancialYear"))
                        .map(line -> {
                            SpotlightDataRow csvRow = new SpotlightDataRow();
                            String[] fields = line.split(",");
                            csvRow.empty = fields[0];
                            csvRow.financialYear = fields[1];
                            csvRow.opExCategory = fields[2];
                            csvRow.department = fields[3];
                            csvRow.emsLevel1 = fields[4];
                            csvRow.movement = Double.parseDouble(fields[5]);
                            return csvRow;
                        })
                        .returns(TypeInformation.of(SpotlightDataRow.class));
        recordStream = recordStream.filter(x -> x.movement != null);
        KeyedStream<SpotlightDataRow, String> keyedStream1 = recordStream.keyBy(record -> record.opExCategory);
        KeyedStream<SpotlightDataRow, String> keyedStream2 = keyedStream1.keyBy(record -> record.department);
        SingleOutputStreamOperator<SpotlightDataRow> aggregatedStream = keyedStream2.reduce((row1, row2) -> {
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

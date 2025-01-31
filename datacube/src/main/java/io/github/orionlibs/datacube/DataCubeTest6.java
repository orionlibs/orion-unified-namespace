package io.github.orionlibs.datacube;

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

public class DataCubeTest6
{
    public static void main(String[] args) throws Exception
    {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(org.apache.flink.api.common.RuntimeExecutionMode.BATCH);
        String path = "D:/temp/sample3.csv";
        FileSource<String> source = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path(path)).build();
        DataStream<String> rawStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "CSVFile1");
        DataStream<SpotlightDataRow> recordStream = rawStream
                        .filter(line -> !line.startsWith(",FinancialYear"))
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
        // First Grouping: by Department
        KeyedStream<SpotlightDataRow, String> keyedByOpExCategory = recordStream.keyBy(record -> record.opExCategory);
        System.out.println("\n=== Grouped by OpExCategory ===");
        try(CloseableIterator<SpotlightDataRow> resultIterator = keyedByOpExCategory.executeAndCollect())
        {
            while(resultIterator.hasNext())
            {
                System.out.println(resultIterator.next());
            }
        }
        // Second Grouping: by Department -> OpExCategory
        KeyedStream<SpotlightDataRow, String> keyedByDepartment = keyedByOpExCategory.keyBy(record -> record.department);
        System.out.println("\n=== Grouped by OpExCategory -> Department ===");
        try(CloseableIterator<SpotlightDataRow> resultIterator = keyedByDepartment.executeAndCollect())
        {
            while(resultIterator.hasNext())
            {
                System.out.println(resultIterator.next());
            }
        }
        // third Grouping: by Department -> OpExCategory -> EMS Level 1
        KeyedStream<SpotlightDataRow, String> keyedByEMSLevel1 = keyedByDepartment.keyBy(record -> record.emsLevel1);
        System.out.println("\n=== Grouped by OpExCategory -> Department -> EMS Level 1 ===");
        try(CloseableIterator<SpotlightDataRow> resultIterator = keyedByEMSLevel1.executeAndCollect())
        {
            while(resultIterator.hasNext())
            {
                System.out.println(resultIterator.next());
            }
        }
    }
}

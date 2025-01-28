package io.github.orionlibs.datacube;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.reader.TextLineInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.triggers.CountTrigger;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.util.Collector;

public class DataCubeTest3
{
    public static void main(String[] args)
    {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        String path = "D:/temp/sample2.csv";
        FileSource<String> source = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path(path)).build();
        DataStream<String> rawStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "CSVFile1");
        DataStream<SpotlightDataRow> recordStream = rawStream.filter(line -> !line.equals(",FinancialYear,OpEx Category,EMS Level 1,EMS Level 2,EMS Level 3,EMS Level 4,Company,Movement,Back Dated Journals,Back Dated Journal Lines Debit Value")).map(line -> {
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
        DataStreamSink<Double> columnSum = recordStream
                        .filter(x -> x.movement != null)
                        .map(row -> row.movement)
                        .windowAll(GlobalWindows.create())
                        .trigger(CountTrigger.of(6141L))
                        .process(new ProcessAllWindowFunction<Double, Double, GlobalWindow>()
                        {
                            @Override
                            public void process(Context context, Iterable<Double> elements, Collector<Double> out)
                            {
                                double sum = 0.0d;
                                for(Double movement : elements)
                                {
                                    sum += movement;
                                }
                                out.collect(sum);
                            }
                        })
                        .addSink(new SinkFunction<>()
                        {
                            @Override
                            public void invoke(Double value, Context context)
                            {
                                System.out.println("Final sum of movement column: " + value);
                            }
                        });
        //.reduce(Double::sum)
        //.returns(Double.class);
        /*columnSum.addSink(new SinkFunction<Double>()
        {
            @Override
            public void invoke(Double value, Context context)
            {
                System.out.println("Sum of movement column: " + value);
            }
        });*/
        try
        {
            env.execute("CSV Processing Job");
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

package io.github.orionlibs.datacube;

import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple11;
import org.apache.flink.api.java.typeutils.TupleTypeInfo;

public class DataCubeTest2
{
    public static void main(String[] args)
    {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        String path = "D:/temp/sample2.csv";
        DataSource<SpotlightDataRow> csvData = env.readCsvFile(path)
                        .fieldDelimiter(",")
                        .ignoreFirstLine()
                        .ignoreInvalidLines()
                        .pojoType(SpotlightDataRow.class,
                                        "empty",
                                        "financialYear",
                                        "opExCategory",
                                        "emsLevel1",
                                        "emsLevel2",
                                        "emsLevel3",
                                        "emsLevel4",
                                        "company",
                                        "movement",
                                        "backDatedJournals",
                                        "backDatedJournalLinesDebitValue");
        /*DataSet<Tuple3<String, String, Long>> csvData = env.readCsvFile(path)
                        .fieldDelimiter(",")
                        .ignoreFirstLine()
                        .types(String.class, String.class, Long.class);*/
        try
        {
            System.out.println("number of rows = " + csvData.count());
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        TupleTypeInfo tupleDataTypes = new TupleTypeInfo(Tuple11.class,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.STRING_TYPE_INFO,
                        BasicTypeInfo.DOUBLE_TYPE_INFO,
                        BasicTypeInfo.DOUBLE_TYPE_INFO,
                        BasicTypeInfo.DOUBLE_TYPE_INFO);
        DataSet<Tuple11<String, String, String, String, String, String, String, String, Double, Double, Double>> tupleData = csvData.map(
                        row -> new Tuple11<>(row.empty, row.financialYear, row.opExCategory, row.emsLevel1, row.emsLevel2, row.emsLevel3, row.emsLevel4, row.company, row.movement, row.backDatedJournals, row.backDatedJournalLinesDebitValue)
        ).returns(tupleDataTypes);
        AggregateOperator<Tuple11<String, String, String, String, String, String, String, String, Double, Double, Double>> sumOfMovement = tupleData.sum(8);
        try
        {
            sumOfMovement.map(x -> x.f8).print();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

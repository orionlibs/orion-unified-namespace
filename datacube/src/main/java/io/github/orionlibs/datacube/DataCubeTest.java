package io.github.orionlibs.datacube;

import java.util.ArrayList;
import java.util.List;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.CloseableIterator;

public class DataCubeTest
{
    public static void main(String[] args)
    {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Fred", 35));
        people.add(new Person("Wilma", 35));
        people.add(new Person("Pebbles", 2));
        DataStream<Person> flintstones = env.fromCollection(people);
        DataStream<Person> adults = flintstones.filter(new FilterFunction<Person>()
        {
            @Override
            public boolean filter(Person person) throws Exception
            {
                return person.age >= 18;
            }
        });
        CloseableIterator<Person> results = null;
        try
        {
            results = adults.executeAndCollect();
            while(results.hasNext())
            {
                System.out.println(results.next().toString());
            }
            results.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        //env.execute();
    }
}

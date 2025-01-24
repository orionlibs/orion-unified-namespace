package io.github.orionlibs.datacube;

public class Person
{
    public String name;
    public Integer age;


    public Person()
    {
    }


    public Person(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }


    public String toString()
    {
        return "name = " + name + " -- age = " + age;
    }
}

package io.github.orionlibs.orion_utilities.object;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

public class Wrapper extends Orion
{
    private Object object;


    public Wrapper(Object object)
    {
        this.object = object;
    }


    public static Wrapper of(Object object)
    {
        return new Wrapper(object);
    }


    public Object getObject()
    {
        return this.object;
    }
}
package io.github.orionlibs.orion_utilities.reflection.classes.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;

public class LoadClassTask extends Orion
{
    public static Class<?> run(String className) throws ClassNotFoundException
    {
        Assert.notEmpty(className, "className input cannot be null/empty.");
        return ClassLoader.getSystemClassLoader().loadClass(className);
    }
}
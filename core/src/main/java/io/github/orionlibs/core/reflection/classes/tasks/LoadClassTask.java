package io.github.orionlibs.core.reflection.classes.tasks;

import io.github.orionlibs.core.exception.Assert;

public class LoadClassTask
{
    public static Class<?> run(String className) throws ClassNotFoundException
    {
        Assert.notEmpty(className, "className input cannot be null/empty.");
        return ClassLoader.getSystemClassLoader().loadClass(className);
    }
}
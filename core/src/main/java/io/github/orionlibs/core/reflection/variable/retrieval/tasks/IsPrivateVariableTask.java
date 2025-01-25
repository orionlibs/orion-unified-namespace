package io.github.orionlibs.core.reflection.variable.retrieval.tasks;

import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IsPrivateVariableTask
{
    public static boolean run(Field variable)
    {
        Assert.notNull(variable, "The given variable input cannot be null.");
        return Modifier.isPrivate(variable.getModifiers());
    }
}
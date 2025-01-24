package io.github.orionlibs.orion_utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IsProtectedVariableTask extends Orion
{
    public static boolean run(Field variable)
    {
        Assert.notNull(variable, "The given variable input cannot be null.");
        return Modifier.isProtected(variable.getModifiers());
    }
}
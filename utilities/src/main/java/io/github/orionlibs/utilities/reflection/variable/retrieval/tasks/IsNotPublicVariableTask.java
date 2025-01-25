package io.github.orionlibs.utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IsNotPublicVariableTask extends Orion
{
    public static boolean run(Field variable)
    {
        Assert.notNull(variable, "The given variable input cannot be null.");
        return !Modifier.isPublic(variable.getModifiers());
    }
}
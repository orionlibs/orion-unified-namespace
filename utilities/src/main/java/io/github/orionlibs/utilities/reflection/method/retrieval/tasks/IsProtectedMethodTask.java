package io.github.orionlibs.utilities.reflection.method.retrieval.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IsProtectedMethodTask extends Orion
{
    public static boolean run(Method method)
    {
        Assert.notNull(method, "method input cannot be null.");
        return Modifier.isProtected(method.getModifiers());
    }
}
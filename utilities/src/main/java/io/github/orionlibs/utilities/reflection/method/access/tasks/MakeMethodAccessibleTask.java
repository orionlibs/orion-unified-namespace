package io.github.orionlibs.utilities.reflection.method.access.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.lang.reflect.Method;

public class MakeMethodAccessibleTask extends Orion
{
    public void run(Method method) throws SecurityException
    {
        Assert.notNull(method, "method input cannot be null.");
        method.setAccessible(true);
    }


    public void run(String method, Object objectMethodBelongsTo, Class<?>[] argumentTypes) throws SecurityException, NoSuchMethodException
    {
        Assert.notNull(method, "method input cannot be null.");
        objectMethodBelongsTo.getClass().getDeclaredMethod(method, argumentTypes).setAccessible(true);
    }
}
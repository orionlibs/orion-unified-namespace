package io.github.orionlibs.orion_utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.lang.reflect.Field;

public class GetDeclaredInstanceVariableTask extends Orion
{
    public static Field run(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        Assert.notEmpty(instanceVariableName, "instanceVariableName input cannot be null/empty.");
        Assert.notNull(object, "object input cannot be null.");
        return run(instanceVariableName, object.getClass());
    }


    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        return aClass.getDeclaredField(instanceVariableName);
    }
}
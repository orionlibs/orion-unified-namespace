package io.github.orionlibs.core.reflection.variable.retrieval.tasks;

import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Field;

public class GetDeclaredProtectedInstanceVariableTask
{
    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Field field = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);
        if(field != null && IsProtectedVariableTask.run(field) && IsNotStaticVariableTask.run(field))
        {
            return field;
        }
        return null;
    }


    public static Field run(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(instanceVariableName, object.getClass());
    }
}
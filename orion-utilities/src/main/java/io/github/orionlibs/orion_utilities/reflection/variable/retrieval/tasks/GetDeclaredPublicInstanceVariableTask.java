package io.github.orionlibs.orion_utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.lang.reflect.Field;

public class GetDeclaredPublicInstanceVariableTask extends Orion
{
    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Field field = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);

        if(field != null && IsPublicVariableTask.run(field) && IsNotStaticVariableTask.run(field))
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
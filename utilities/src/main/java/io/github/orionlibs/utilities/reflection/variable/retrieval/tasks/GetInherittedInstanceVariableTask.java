package io.github.orionlibs.utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.lang.reflect.Field;

public class GetInherittedInstanceVariableTask extends Orion
{
    public static Field run(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(instanceVariableName, object.getClass());
    }


    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Assert.notEmpty(instanceVariableName, "instanceVariableName input cannot be null/empty.");
        Assert.notNull(aClass, "class input cannot be null.");
        Field declaredInstanceVariable = null;
        Class<?> superclass = aClass.getSuperclass();

        while(superclass != null)
        {
            declaredInstanceVariable = GetDeclaredInstanceVariableTask.run(instanceVariableName, superclass);

            if(declaredInstanceVariable != null)
            {
                break;
            }

            superclass = superclass.getSuperclass();
        }

        return declaredInstanceVariable;
    }
}
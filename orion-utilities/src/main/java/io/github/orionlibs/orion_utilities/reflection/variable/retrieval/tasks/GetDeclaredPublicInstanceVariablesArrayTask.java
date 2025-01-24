package io.github.orionlibs.orion_utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class GetDeclaredPublicInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> declaredPublicInstanceVariables = new ArrayList<Field>();

        for(Field instanceVariable : aClass.getDeclaredFields())
        {

            if(Modifier.isPublic(instanceVariable.getModifiers()) && IsNotStaticVariableTask.run(instanceVariable))
            {
                declaredPublicInstanceVariables.add(instanceVariable);
            }

        }

        return declaredPublicInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}
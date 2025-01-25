package io.github.orionlibs.utilities.reflection.method.retrieval.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetInherittedMethodsArrayTask extends Orion
{
    public static Method[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Method> instanceMethods = new ArrayList<Method>();
        List<Method> publicMethods = Arrays.asList(GetDeclaredPublicMethodsArrayTask.run(aClass));
        List<Method> publicAndInherittedMethods = Arrays.asList(aClass.getMethods());
        instanceMethods.addAll(publicAndInherittedMethods);
        //these are the inheritted methods only
        instanceMethods.removeAll(publicMethods);
        return instanceMethods.toArray(new Method[0]);
    }


    public static Method[] run(Object object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}
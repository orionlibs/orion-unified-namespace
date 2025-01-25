package io.github.orionlibs.utilities.reflection.constructor.retrieval;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.reflection.constructor.retrieval.tasks.GetDeclaredConstructorTask;
import io.github.orionlibs.utilities.reflection.constructor.retrieval.tasks.GetPublicConstructorTask;
import java.lang.reflect.Constructor;

public class ReflectionConstructorRetrievalService extends OrionService
{
    public static Constructor<?> getDeclaredConstructor(Object object, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetDeclaredConstructorTask.run(object, constructorParameterTypes);
    }


    public static Constructor<?> getDeclaredConstructor(Class<?> aClass, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetDeclaredConstructorTask.run(aClass, constructorParameterTypes);
    }


    public static Constructor<?> getPublicConstructor(Object object, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetPublicConstructorTask.run(object, constructorParameterTypes);
    }


    public static Constructor<?> getPublicConstructor(Class<?> aClass, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetPublicConstructorTask.run(aClass, constructorParameterTypes);
    }
}
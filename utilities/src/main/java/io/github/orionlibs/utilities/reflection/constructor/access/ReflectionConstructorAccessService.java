package io.github.orionlibs.utilities.reflection.constructor.access;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.reflection.constructor.access.tasks.CallConstructorTask;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructorAccessService extends OrionService
{
    public static Object callConstructor(Constructor<?> constructor, Object... constructorArguments) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
    {
        return CallConstructorTask.run(constructor, constructorArguments);
    }
}
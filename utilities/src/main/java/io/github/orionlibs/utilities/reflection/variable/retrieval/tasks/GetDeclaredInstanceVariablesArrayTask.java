package io.github.orionlibs.utilities.reflection.variable.retrieval.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.stream.OrionStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class GetDeclaredInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "aClass input cannot be null.");
        Field[] fields = aClass.getDeclaredFields();
        Stream<Field> stream = Arrays.stream(fields)
                        .filter(field -> IsNotStaticVariableTask.run(field));
        return OrionStream.getAsArray(stream, Field.class);
    }


    public static Field[] run(Object object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}
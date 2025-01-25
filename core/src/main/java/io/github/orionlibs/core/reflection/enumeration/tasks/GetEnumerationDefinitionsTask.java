package io.github.orionlibs.core.reflection.enumeration.tasks;

import io.github.orionlibs.core.exception.Assert;

public class GetEnumerationDefinitionsTask
{
    @SuppressWarnings(
                    {"rawtypes"})
    public static Enum[] run(Class<Enum> enumerationClass)
    {
        Assert.notNull(enumerationClass, "enumerationClass input cannot be null.");
        return enumerationClass.getEnumConstants();
    }
}
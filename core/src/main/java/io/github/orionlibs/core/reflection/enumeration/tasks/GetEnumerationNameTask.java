package io.github.orionlibs.core.reflection.enumeration.tasks;

import io.github.orionlibs.core.exception.Assert;

public class GetEnumerationNameTask
{
    @SuppressWarnings(
                    {"rawtypes"})
    public static String run(Enum enumerationDefinition)
    {
        Assert.notNull(enumerationDefinition, "enumerationDefinition input cannot be null.");
        return enumerationDefinition.name();
    }
}
package io.github.orionlibs.orion_utilities.reflection.enumeration.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;

public class GetEnumerationNameTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes"})
    public static String run(Enum enumerationDefinition)
    {
        Assert.notNull(enumerationDefinition, "enumerationDefinition input cannot be null.");
        return enumerationDefinition.name();
    }
}
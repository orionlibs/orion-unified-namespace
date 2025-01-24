package io.github.orionlibs.orion_utilities.reflection.enumeration.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.reflection.classes.ReflectionClassesService;

public class InstantiateEnumerationTask extends Orion
{
    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Class<Enum> run(String enumerationPath) throws ClassNotFoundException
    {
        Assert.notEmpty(enumerationPath, "enumerationPath input cannot be null/empty.");
        return (Class<Enum>)ReflectionClassesService.loadClass(enumerationPath);
    }
}
package io.github.orionlibs.orion_utilities.reflection.variable.access.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class MakeInstanceVariableAccessibleTask extends Orion
{
    public void run(Field instanceVariable) throws InaccessibleObjectException, SecurityException
    {
        Assert.notNull(instanceVariable, "instanceVariable input cannot be null.");
        instanceVariable.setAccessible(true);
    }
}
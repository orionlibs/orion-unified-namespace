package io.github.orionlibs.orion_utilities.reflection.variable.access.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.InaccessibleException;
import java.lang.reflect.Field;

public class InjectStringToInstanceVariableTask extends Orion
{
    public void run(Object object, String stringToInject, Field instanceVariable) throws InaccessibleException
    {

        try
        {
            instanceVariable.set(object, stringToInject);
        }
        catch(IllegalArgumentException e)
        {
            throw e;
        }
        catch(IllegalAccessException e)
        {
            throw new InaccessibleException("The instance variable is inaccessible.");
        }

    }
}
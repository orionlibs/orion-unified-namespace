package io.github.orionlibs.orion_utilities.reflection.acccessible_object.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.reflection.constructor.retrieval.tasks.GetDeclaredConstructorsArrayTask;
import io.github.orionlibs.orion_utilities.reflection.method.retrieval.tasks.GetDeclaredMethodsArrayTask;
import io.github.orionlibs.orion_utilities.reflection.variable.retrieval.tasks.GetDeclaredInstanceVariablesArrayTask;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetDeclaredAccessibleObjectsArrayTask extends Orion
{
    public static AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(GetDeclaredInstanceVariablesArrayTask.run(aClass)));
        accessibleObjects.addAll(Arrays.asList(GetDeclaredConstructorsArrayTask.run(aClass)));
        accessibleObjects.addAll(Arrays.asList(GetDeclaredMethodsArrayTask.run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public static AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
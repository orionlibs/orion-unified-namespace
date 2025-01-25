package io.github.orionlibs.core.reflection.acccessible_object.tasks;

import io.github.orionlibs.core.reflection.method.retrieval.tasks.GetInherittedMethodsArrayTask;
import io.github.orionlibs.core.reflection.variable.retrieval.tasks.GetInherittedInstanceVariablesArrayTask;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetInherittedAccessibleObjectsArrayTask
{
    public static AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(GetInherittedInstanceVariablesArrayTask.run(aClass)));
        accessibleObjects.addAll(Arrays.asList(GetInherittedMethodsArrayTask.run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public static AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
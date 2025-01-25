package io.github.orionlibs.utilities.reflection.object.equality;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.reflection.object.equality.tasks.AreObjectsEqualTask;

public class ObjectsEqualityService extends OrionService
{
    public static boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return AreObjectsEqualTask.run(object1, object2, moreObjects);
    }
}
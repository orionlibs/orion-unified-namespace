package io.github.orionlibs.orion_utilities.comparator;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.comparator.tasks.CompareToTask;

public class CompareToService<T> extends Orion
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}
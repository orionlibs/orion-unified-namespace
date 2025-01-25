package io.github.orionlibs.utilities.comparator;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.comparator.tasks.CompareToTask;

public class CompareToService<T> extends Orion
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}
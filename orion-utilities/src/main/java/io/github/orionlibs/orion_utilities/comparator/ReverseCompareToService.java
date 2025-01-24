package io.github.orionlibs.orion_utilities.comparator;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.comparator.tasks.ReverseCompareToTask;

public class ReverseCompareToService<T> extends Orion
{
    public int compareTo(T x, T y)
    {
        return ReverseCompareToTask.run(x, y);
    }
}
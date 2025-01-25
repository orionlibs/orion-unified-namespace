package io.github.orionlibs.core.comparator;

import io.github.orionlibs.core.comparator.tasks.ReverseCompareToTask;

public class ReverseCompareToService<T>
{
    public int compareTo(T x, T y)
    {
        return ReverseCompareToTask.run(x, y);
    }
}
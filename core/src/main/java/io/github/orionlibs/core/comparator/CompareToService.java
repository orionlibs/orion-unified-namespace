package io.github.orionlibs.core.comparator;

import io.github.orionlibs.core.comparator.tasks.CompareToTask;

public class CompareToService<T>
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}
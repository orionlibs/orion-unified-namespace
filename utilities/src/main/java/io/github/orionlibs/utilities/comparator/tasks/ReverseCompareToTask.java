package io.github.orionlibs.utilities.comparator.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;

public class ReverseCompareToTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> int run(T x, T y)
    {

        if(x == null || y == null || x instanceof Comparable == false || y instanceof Comparable == false)
        {
            return 0;
        }
        else
        {
            return ((Comparable<T>)y).compareTo(x);
        }

    }
}
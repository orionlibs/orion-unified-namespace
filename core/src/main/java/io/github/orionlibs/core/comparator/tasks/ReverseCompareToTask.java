package io.github.orionlibs.core.comparator.tasks;

public class ReverseCompareToTask<T>
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
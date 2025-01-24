package io.github.orionlibs.orion_utilities.comparator;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import java.util.Comparator;

public class ReverseElementComparator<T> extends Orion implements Comparator<T>
{
    @Override
    public int compare(T x, T y)
    {
        return new ReverseCompareToService<T>().compareTo(x, y);
    }
}
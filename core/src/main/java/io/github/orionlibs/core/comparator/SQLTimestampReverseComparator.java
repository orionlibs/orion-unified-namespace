package io.github.orionlibs.core.comparator;

import java.sql.Timestamp;
import java.util.Comparator;

public class SQLTimestampReverseComparator implements Comparator<Timestamp>
{
    @Override
    public int compare(Timestamp x, Timestamp y)
    {
        return y.compareTo(x);
    }
}
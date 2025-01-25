package io.github.orionlibs.utilities.comparator;

import io.github.orionlibs.utilities.abstraction.Orion;
import java.sql.Timestamp;
import java.util.Comparator;

public class SQLTimestampReverseComparator extends Orion implements Comparator<Timestamp>
{
    @Override
    public int compare(Timestamp x, Timestamp y)
    {
        return y.compareTo(x);
    }
}
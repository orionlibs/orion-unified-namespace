package io.github.orionlibs.orion_utilities.comparator;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import java.sql.Timestamp;
import java.util.Comparator;

public class SQLTimestampComparator extends Orion implements Comparator<Timestamp>
{
    @Override
    public int compare(Timestamp x, Timestamp y)
    {
        return x.compareTo(y);
    }
}
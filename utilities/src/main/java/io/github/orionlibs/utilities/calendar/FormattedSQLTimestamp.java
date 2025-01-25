package io.github.orionlibs.utilities.calendar;

import io.github.orionlibs.utilities.abstraction.Orion;

public class FormattedSQLTimestamp extends Orion
{
    public static void setupFormattedDateTime(SQLTimestamp timestamp)
    {
        SQLTimestampFormatter formatter = SQLTimestampFormatter.builder()
                        .timestamp(timestamp)
                        .build();
        formatter.setupFormattedDateTime();
    }


    public static void setupFormattedDateTimeUTC(SQLTimestamp timestamp)
    {
        SQLTimestampFormatter formatter = SQLTimestampFormatter.builder()
                        .timestamp(timestamp)
                        .build();
        formatter.setupFormattedDateTimeUTC();
    }
}
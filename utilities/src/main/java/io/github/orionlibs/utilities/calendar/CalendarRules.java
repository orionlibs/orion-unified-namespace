package io.github.orionlibs.utilities.calendar;

import io.github.orionlibs.utilities.abstraction.OrionRule;
import io.github.orionlibs.utilities.exception.Assert;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class CalendarRules extends OrionRule
{
    public static void isValid(Instant date)
    {
        Assert.notNull(date, "Instant is null.");
    }


    public static void isValid(Timestamp date)
    {
        Assert.notNull(date, "Timestamp is null.");
    }


    public static void isValid(ZoneId zoneID)
    {
        Assert.notNull(zoneID, "zoneID is null.");
    }


    public static void isValid(ChronoUnit unit)
    {
        Assert.notNull(unit, "No temporal unit provided.");
    }
}
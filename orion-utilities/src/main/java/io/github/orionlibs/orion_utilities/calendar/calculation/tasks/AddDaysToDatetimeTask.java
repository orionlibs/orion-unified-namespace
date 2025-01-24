package io.github.orionlibs.orion_utilities.calendar.calculation.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.CalendarRules;
import io.github.orionlibs.orion_utilities.calendar.CalendarService;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTime;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTimeRules;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddDaysToDatetimeTask extends Orion
{
    public static DateTime run(DateTime datetime, long numberOfDays, ZoneId zone)
    {
        DateTimeRules.isValidIgnoringZoneID(datetime);
        CalendarRules.isValid(zone);

        if(numberOfDays == 0)
        {
            return datetime.getCopy();
        }
        else
        {
            ZonedDateTime zonedDatetime = CalendarService.convertInstantToLocalDate(datetime.toInstant(), zone)
                            .plusDays(numberOfDays)
                            .atStartOfDay(zone);
            return DateTime.of(zonedDatetime);
        }

    }
}
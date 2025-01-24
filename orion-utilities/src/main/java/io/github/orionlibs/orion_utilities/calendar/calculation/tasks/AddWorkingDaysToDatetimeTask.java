package io.github.orionlibs.orion_utilities.calendar.calculation.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.CalendarRules;
import io.github.orionlibs.orion_utilities.calendar.CalendarService;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTime;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTimeRules;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddWorkingDaysToDatetimeTask extends Orion
{
    public static DateTime run(DateTime datetime, long numberOfDays, ZoneId zone)
    {
        DateTimeRules.isValidIgnoringZoneID(datetime);
        CalendarRules.isValid(zone);
        LocalDate localDate = CalendarService.convertInstantToLocalDate(datetime.toInstant(), zone);
        ZonedDateTime zonedDatetime = null;

        while(numberOfDays > 0)
        {
            zonedDatetime = localDate.plusDays(1).atStartOfDay(zone);
            localDate = zonedDatetime.toLocalDate();

            if(CalendarService.isWeekday(zonedDatetime))
            {
                numberOfDays--;
            }

        }

        return DateTime.of(zonedDatetime);
    }
}
package io.github.orionlibs.utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.utilities.calendar.date.Date;
import io.github.orionlibs.utilities.calendar.date.DateRules;
import io.github.orionlibs.core.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoDatesInDaysTask
{
    public static long run(Date date1, Date date2) throws InvalidArgumentException
    {
        DateRules.isValid(date1);
        DateRules.isValid(date2);
        return ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
    }
}

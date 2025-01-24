package io.github.orionlibs.orion_utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.date.Date;
import io.github.orionlibs.orion_utilities.calendar.date.DateRules;
import io.github.orionlibs.orion_utilities.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoDatesInDaysTask extends Orion
{
    public static long run(Date date1, Date date2) throws InvalidArgumentException
    {
        DateRules.isValid(date1);
        DateRules.isValid(date2);
        return ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
    }
}

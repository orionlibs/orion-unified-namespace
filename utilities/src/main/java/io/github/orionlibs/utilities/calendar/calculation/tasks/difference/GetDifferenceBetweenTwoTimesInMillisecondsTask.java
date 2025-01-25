package io.github.orionlibs.utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.utilities.calendar.time.Time;
import io.github.orionlibs.utilities.calendar.time.TimeRules;
import io.github.orionlibs.core.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoTimesInMillisecondsTask
{
    public static long run(Time time1, Time time2) throws InvalidArgumentException
    {
        TimeRules.isValid(time1);
        TimeRules.isValid(time2);
        return ChronoUnit.MILLIS.between(time1.toLocalTime(), time2.toLocalTime());
    }
}

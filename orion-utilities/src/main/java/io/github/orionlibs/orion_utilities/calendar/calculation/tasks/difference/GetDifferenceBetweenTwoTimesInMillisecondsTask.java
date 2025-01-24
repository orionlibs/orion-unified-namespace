package io.github.orionlibs.orion_utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.time.Time;
import io.github.orionlibs.orion_utilities.calendar.time.TimeRules;
import io.github.orionlibs.orion_utilities.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoTimesInMillisecondsTask extends Orion
{
    public static long run(Time time1, Time time2) throws InvalidArgumentException
    {
        TimeRules.isValid(time1);
        TimeRules.isValid(time2);
        return ChronoUnit.MILLIS.between(time1.toLocalTime(), time2.toLocalTime());
    }
}

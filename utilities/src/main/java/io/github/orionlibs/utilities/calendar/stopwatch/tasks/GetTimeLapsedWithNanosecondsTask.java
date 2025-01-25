package io.github.orionlibs.utilities.calendar.stopwatch.tasks;

import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.utilities.calendar.Calendar;
import io.github.orionlibs.utilities.calendar.stopwatch.Stopwatch;

public class GetTimeLapsedWithNanosecondsTask
{
    public static String run(Stopwatch stopwatch, String timeElapsed)
    {
        Assert.notNull(stopwatch, "The stopwatch input cannot be null.");
        Assert.notEmpty(timeElapsed, "The timeElapsed input cannot be null/empty.");
        long totalSecondsElapsed = stopwatch.getTotalSecondsElapsed();
        long totalMinutesElapsed = stopwatch.getTotalMinutesElapsed();
        long totalHoursElapsed = stopwatch.getTotalHoursElapsed();
        long totalHoursInSeconds = totalHoursElapsed * Calendar.secondsInAMinute;
        long totalMinutesInSeconds = totalMinutesElapsed * Calendar.secondsInAMinute;
        totalSecondsElapsed += totalMinutesInSeconds + totalHoursInSeconds;
        long nanoseconds = stopwatch.getNanosecondsElapsed() - (totalSecondsElapsed * Calendar.nanosecondsInASecond);
        return timeElapsed + "." + nanoseconds;
    }
}
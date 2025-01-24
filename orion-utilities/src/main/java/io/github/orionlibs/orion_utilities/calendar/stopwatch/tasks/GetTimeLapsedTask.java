package io.github.orionlibs.orion_utilities.calendar.stopwatch.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.Calendar;
import io.github.orionlibs.orion_utilities.calendar.stopwatch.Stopwatch;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.string.StringsService;

public class GetTimeLapsedTask extends Orion
{
    public String run(Stopwatch stopwatch)
    {
        Assert.notNull(stopwatch, "The stopwatch input cannot be null.");
        long totalMillisecondsElapsed = stopwatch.getNanosecondsElapsed() / Calendar.nanosecondsInAMillisecond;
        long totalSecondsElapsed = stopwatch.getNanosecondsElapsed() / Calendar.nanosecondsInASecond;
        long totalMinutesElapsed = totalSecondsElapsed / Calendar.secondsInAMinute;
        long totalHoursElapsed = totalMinutesElapsed / Calendar.secondsInAMinute;
        totalSecondsElapsed = totalSecondsElapsed - (totalMinutesElapsed * Calendar.secondsInAMinute);
        stopwatch.setTotalMillisecondsElapsed(totalMillisecondsElapsed);
        stopwatch.setTotalSecondsElapsed(totalSecondsElapsed);
        stopwatch.setTotalMinutesElapsed(totalMinutesElapsed);
        stopwatch.setTotalHoursElapsed(totalHoursElapsed);
        String secondsElapsed = StringsService.formatWith2Characters(totalSecondsElapsed);
        String minutesElapsed = StringsService.formatWith2Characters(totalMinutesElapsed);
        String hoursElapsed = StringsService.formatWith2Characters(totalHoursElapsed);
        return hoursElapsed + ":" + minutesElapsed + ":" + secondsElapsed;
    }
}
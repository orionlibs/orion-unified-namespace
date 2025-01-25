package io.github.orionlibs.utilities.calendar.calculation.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.calendar.CalendarService;
import io.github.orionlibs.utilities.calendar.WeekPeriod;
import io.github.orionlibs.utilities.calendar.WeekPeriods;
import io.github.orionlibs.utilities.calendar.date.Date;
import io.github.orionlibs.utilities.calendar.datetime.DateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllWeeksOfTheLastNWeeksAsPairsOfStartAndEndDateWithFirstDayOfWeekBeingMondayTask extends Orion
{
    public static WeekPeriods run(int numberOfWeeksToReturn)
    {
        List<WeekPeriod> weeks = new ArrayList<>();
        Date lastSunday = CalendarService.getLastSundayDateBasedOnCurrentDate();
        DateTime lastSundayTemp = DateTime.of(lastSunday);

        for(int i = 0; i < numberOfWeeksToReturn; i++)
        {
            int daysToSubtractToFindStartOfWeek = (-7 * i) - 6;
            Date startOfWeek = CalendarService.addDaysToDatetime(lastSundayTemp, daysToSubtractToFindStartOfWeek).getDate();
            weeks.add(CalendarService.buildWeekPeriodSplitByHyphensYearFirst(startOfWeek.getDateStringSplitByHyphensYearFirst()));
        }

        return WeekPeriods.of(weeks);
    }
}
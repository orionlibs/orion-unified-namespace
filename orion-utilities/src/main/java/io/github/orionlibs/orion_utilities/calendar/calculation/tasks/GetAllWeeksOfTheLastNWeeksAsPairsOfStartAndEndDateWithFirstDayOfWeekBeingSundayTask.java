package io.github.orionlibs.orion_utilities.calendar.calculation.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.CalendarService;
import io.github.orionlibs.orion_utilities.calendar.WeekPeriod;
import io.github.orionlibs.orion_utilities.calendar.date.Date;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllWeeksOfTheLastNWeeksAsPairsOfStartAndEndDateWithFirstDayOfWeekBeingSundayTask extends Orion
{
    public static List<WeekPeriod> run(int numberOfWeeksToReturn)
    {
        List<WeekPeriod> weeks = new ArrayList<>();
        Date lastSaturday = CalendarService.getLastSaturdayDateBasedOnCurrentDate();
        DateTime lastSaturdayTemp = DateTime.of(lastSaturday);

        for(int i = 0; i < numberOfWeeksToReturn; i++)
        {
            int daysToSubtractToFindStartOfWeek = (-7 * i) - 6;
            Date startOfWeek = CalendarService.addDaysToDatetime(lastSaturdayTemp, daysToSubtractToFindStartOfWeek).getDate();
            weeks.add(CalendarService.buildWeekPeriodSplitByHyphensYearFirst(startOfWeek.getDateStringSplitByHyphensYearFirst()));
        }

        return weeks;
    }
}
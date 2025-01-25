package io.github.orionlibs.utilities.calendar.tasks.format;

import io.github.orionlibs.utilities.calendar.CalendarService;
import io.github.orionlibs.utilities.calendar.date.Date;

public class PrintDateAsTodayOrTomorrowOrFullDateTask
{
    public static String run(Date date)
    {
        Date currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings();
        String result = "";

        if(date.equals(currentDate))
        {
            result = "today";
        }
        else
        {

            if(date.equals(CalendarService.addDaysToCurrentDatetimeAdjustingForDaylightSavings(1).getDate()))
            {
                result = "tomorrow";
            }
            else
            {
                result = date.getDateStringSplitByHyphensYearFirst();
            }

        }

        return result;
    }
}
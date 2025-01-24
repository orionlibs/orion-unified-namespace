package io.github.orionlibs.orion_utilities.calendar.tasks.format;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.CalendarService;
import io.github.orionlibs.orion_utilities.calendar.date.Date;

public class PrintDateAsTodayOrTomorrowOrFullDateTask extends Orion
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
package io.github.orionlibs.utilities.calendar.tasks.format;

import io.github.orionlibs.utilities.calendar.CalendarService;
import io.github.orionlibs.utilities.calendar.date.Date;
import io.github.orionlibs.utilities.calendar.date.InvalidDateException;
import io.github.orionlibs.utilities.calendar.datetime.DateTime;

public class PrintDateAsTodayOrTomorrowOrFullDateTimeTask
{
    public static String run(DateTime datetime, boolean printYear) throws InvalidDateException
    {

        if(datetime != null)
        {
            Date currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings();
            String result = "";

            if(datetime.getDate().equals(currentDate))
            {
                result = "today @ " + datetime.printTimeAsIsWithoutSeconds();
            }
            else
            {

                if(datetime.getDate().equals(CalendarService.addDaysToCurrentDatetimeAdjustingForDaylightSavings(1).getDate()))
                {
                    result = "tomorrow @ " + datetime.printTimeAsIsWithoutSeconds();
                }
                else
                {

                    if(printYear)
                    {
                        result = datetime.printInInternationalFormatWithAtSymbolWithoutSeconds();
                    }
                    else
                    {
                        result = datetime.printLongDateWithoutYearWithAtSymbolWithoutSeconds();
                    }

                }

            }

            return result;
        }
        else
        {
            return "";
        }

    }
}
package io.github.orionlibs.utilities.calendar.calculation.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.calendar.date.Date;
import io.github.orionlibs.utilities.calendar.date.DateRules;
import io.github.orionlibs.utilities.calendar.datetime.DateTime;
import io.github.orionlibs.utilities.calendar.datetime.DateTimeRules;
import io.github.orionlibs.utilities.exception.InvalidArgumentException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GetNumberOfMonthDaysTask extends Orion
{
    public static int run(Date date) throws InvalidArgumentException
    {
        DateRules.isValid(date);
        Calendar calendar = new GregorianCalendar(date.getYear(), date.getMonth() - 1, date.getDay());
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public static int run(DateTime date) throws InvalidArgumentException
    {
        DateTimeRules.isValidIgnoringZoneID(date);
        DateRules.isValid(date.getDate());
        return run(date.getDate());
    }
}
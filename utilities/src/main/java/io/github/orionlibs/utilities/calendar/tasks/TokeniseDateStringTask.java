package io.github.orionlibs.utilities.calendar.tasks;

import io.github.orionlibs.utilities.calendar.date.DateRules;
import io.github.orionlibs.utilities.calendar.date.InvalidDateException;

public class TokeniseDateStringTask
{
    public static String[] run(String date) throws InvalidDateException
    {
        DateRules.isValid(date);
        if(date.indexOf("-") >= 0)
        {
            return date.split("-");
        }
        else if(date.indexOf("/") >= 0)
        {
            return date.split("/");
        }
        else
        {
            return null;
        }
    }
}
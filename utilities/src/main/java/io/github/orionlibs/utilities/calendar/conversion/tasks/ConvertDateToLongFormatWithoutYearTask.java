package io.github.orionlibs.utilities.calendar.conversion.tasks;

import io.github.orionlibs.utilities.calendar.Calendar;
import io.github.orionlibs.utilities.calendar.DateTokens;

public class ConvertDateToLongFormatWithoutYearTask
{
    public static String run(DateTokens dateParts)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(dateParts.getDays());
        sb.append(" ");
        sb.append(Calendar.monthNumberToAbbreviatedNameMapper.get(dateParts.getMonth()));
        return sb.toString();
    }
}
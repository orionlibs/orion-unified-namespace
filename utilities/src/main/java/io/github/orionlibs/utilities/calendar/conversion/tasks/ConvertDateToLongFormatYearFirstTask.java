package io.github.orionlibs.utilities.calendar.conversion.tasks;

import io.github.orionlibs.utilities.calendar.Calendar;
import io.github.orionlibs.utilities.calendar.DateTokens;

public class ConvertDateToLongFormatYearFirstTask
{
    public static String run(DateTokens dateParts)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(dateParts.getYear());
        sb.append(" ");
        sb.append(Calendar.monthNumberToAbbreviatedNameMapper.get(dateParts.getMonth()));
        sb.append(" ");
        sb.append(dateParts.getDays());
        return sb.toString();
    }
}
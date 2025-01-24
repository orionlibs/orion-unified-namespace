package io.github.orionlibs.orion_utilities.calendar.conversion.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.Calendar;
import io.github.orionlibs.orion_utilities.calendar.DateTokens;

public class ConvertDateToLongFormatYearFirstTask extends Orion
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
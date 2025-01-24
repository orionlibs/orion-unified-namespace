package io.github.orionlibs.orion_utilities.calendar.conversion.tasks.sqldate;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.date.Date;
import io.github.orionlibs.orion_utilities.calendar.date.DateRules;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertSQLDateToDateTimeObjectTask extends Orion
{
    public static DateTime run(String SQLDate)
    {
        DateRules.isValidSQLDate(SQLDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate localDate = LocalDate.parse(SQLDate, formatter);
        Date date = Date.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        return DateTime.of(date);
    }


    public static DateTime run(java.sql.Date SQLDate)
    {
        DateRules.isValidSQLDate(SQLDate);
        Date date = Date.of(SQLDate.getYear() + 1900, SQLDate.getMonth() + 1, SQLDate.getDate());
        return DateTime.of(date);
    }
}
package io.github.orionlibs.orion_utilities.calendar.conversion.tasks.sqldate;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.date.Date;
import io.github.orionlibs.orion_utilities.calendar.date.DateRules;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertSQLDateToDateObjectTask extends Orion
{
    public static Date run(String SQLDate)
    {
        DateRules.isValidSQLDate(SQLDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate localDate = LocalDate.parse(SQLDate, formatter);
        return Date.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }


    public static Date run(java.sql.Date SQLDate)
    {
        DateRules.isValidSQLDate(SQLDate);
        return Date.of(SQLDate.getYear(), SQLDate.getMonth() + 1, SQLDate.getDate());
    }
}
package io.github.orionlibs.orion_utilities.calendar.conversion.tasks.sqldate;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.calendar.date.Date;
import io.github.orionlibs.orion_utilities.calendar.datetime.DateTime;
import io.github.orionlibs.orion_utilities.calendar.time.Time;
import java.sql.Timestamp;

public class ConvertSQLTimestampToDateTimeObjectTask extends Orion
{
    public static DateTime run(Timestamp SQLDate)
    {

        if(SQLDate != null)
        {
            Date date = Date.of(SQLDate.getYear() + 1900, SQLDate.getMonth() + 1, SQLDate.getDate());
            Time time = Time.of(SQLDate.getHours(), SQLDate.getMinutes(), SQLDate.getSeconds());
            return DateTime.of(date, time);
        }
        else
        {
            return null;
        }

    }
}
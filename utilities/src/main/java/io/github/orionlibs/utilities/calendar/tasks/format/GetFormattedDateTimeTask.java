package io.github.orionlibs.utilities.calendar.tasks.format;

import io.github.orionlibs.utilities.calendar.FormattedDateTime;
import io.github.orionlibs.utilities.calendar.FormattedDateTime.FormattedDateTimeBuilder;
import io.github.orionlibs.utilities.calendar.date.InvalidDateException;
import io.github.orionlibs.utilities.calendar.datetime.DateTime;
import io.github.orionlibs.utilities.calendar.datetime.DateTimeRules;

public class GetFormattedDateTimeTask
{
    public static FormattedDateTime run(DateTime datetime) throws InvalidDateException
    {
        DateTimeRules.isValid(datetime);
        FormattedDateTimeBuilder formattedDateTimeBuilder = FormattedDateTime.builder();
        if(datetime.getDate() != null)
        {
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitByHyphens(datetime.getDate().getDateStringSplitByHyphens());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitByHyphensYearFirst(datetime.getDate().getDateStringSplitByHyphensYearFirst());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitBySlashes(datetime.getDate().getDateStringSplitBySlashes());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitBySlashesYearFirst(datetime.getDate().getDateStringSplitBySlashesYearFirst());
            formattedDateTimeBuilder = formattedDateTimeBuilder.longDate(datetime.getDate().getLongDateYearFirstString());
        }
        if(datetime.getTime() != null)
        {
            formattedDateTimeBuilder = formattedDateTimeBuilder.time(datetime.getTime().getTimeString());
            formattedDateTimeBuilder = formattedDateTimeBuilder.timeWithISOFormat(datetime.getTime().getTimeStringInISOFormat());
        }
        return formattedDateTimeBuilder.build();
    }
}
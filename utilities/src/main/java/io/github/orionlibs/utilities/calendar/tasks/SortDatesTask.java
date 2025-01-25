package io.github.orionlibs.utilities.calendar.tasks;

import io.github.orionlibs.utilities.calendar.date.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDatesTask
{
    public static List<Date> run(List<Date> dates)
    {
        List<LocalDate> datesAsZonedDates = new ArrayList<>(dates.size());
        dates.forEach(date -> datesAsZonedDates.add(date.toLocalDate()));
        Collections.sort(datesAsZonedDates);
        List<Date> sortedDates = new ArrayList<>(dates.size());
        datesAsZonedDates.forEach(date -> sortedDates.add(Date.of(date)));
        return sortedDates;
    }
}
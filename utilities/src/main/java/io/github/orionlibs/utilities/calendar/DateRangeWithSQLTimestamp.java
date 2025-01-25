package io.github.orionlibs.utilities.calendar;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DateRangeWithSQLTimestamp extends Orion
{
    private SQLTimestamp startDate;
    private SQLTimestamp endDate;


    public static DateRangeWithSQLTimestamp of()
    {
        return DateRangeWithSQLTimestamp.builder().build();
    }


    @Override
    public DateRangeWithSQLTimestamp clone()
    {
        return (DateRangeWithSQLTimestamp)CloningService.clone(this);
    }


    public DateRangeWithSQLTimestamp getCopy()
    {
        return this.clone();
    }
}
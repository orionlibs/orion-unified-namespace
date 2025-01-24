package io.github.orionlibs.orion_utilities.calendar;

import io.github.orionlibs.orion_utilities.abstraction.OrionValueObject;
import java.util.List;
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
public class WeekPeriods extends OrionValueObject
{
    private List<WeekPeriod> weekPeriods;


    public static WeekPeriods of(List<WeekPeriod> weekPeriods)
    {
        return WeekPeriods.builder()
                        .weekPeriods(weekPeriods)
                        .build();
    }
}
package io.github.orionlibs.utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.core.utility.OrionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GetChronoUnitsToUseTask
{
    @SuppressWarnings("unchecked")
    static List<String> run(String units, String[] unitsToUse)
    {

        if(!units.isEmpty())
        {
            List<String> unitsToUseList = new ArrayList<>(Arrays.asList(unitsToUse));
            List<String> unitsFromInputToUse = new ArrayList<>(Arrays.asList(units.split("")));
            return OrionUtils.getIntersection(unitsToUseList, unitsFromInputToUse);
        }
        else
        {
            return Arrays.asList(unitsToUse);
        }

    }
}

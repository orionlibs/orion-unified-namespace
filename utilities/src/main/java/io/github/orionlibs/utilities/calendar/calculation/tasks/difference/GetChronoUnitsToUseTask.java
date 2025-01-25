package io.github.orionlibs.utilities.calendar.calculation.tasks.difference;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.data.structure.list.ListService;
import io.github.orionlibs.utilities.data.structure.list.OrionList;
import io.github.orionlibs.utilities.data.structure.list.type.OrionArrayList;
import java.util.Arrays;
import java.util.List;

class GetChronoUnitsToUseTask extends Orion
{
    @SuppressWarnings("unchecked")
    static List<String> run(String units, String[] unitsToUse)
    {

        if(!units.isEmpty())
        {
            OrionList<String> unitsToUseList = OrionArrayList.<String>of(unitsToUse);
            OrionList<String> unitsFromInputToUse = OrionArrayList.<String>of(units.split(""));
            return ListService.<String>getIntersection(unitsToUseList, unitsFromInputToUse).getAsList();
        }
        else
        {
            return Arrays.asList(unitsToUse);
        }

    }
}

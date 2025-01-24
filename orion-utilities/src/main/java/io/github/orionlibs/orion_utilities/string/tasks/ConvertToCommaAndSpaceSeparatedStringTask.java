package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.string.StringsService;
import java.util.List;

public class ConvertToCommaAndSpaceSeparatedStringTask extends Orion
{
    public static String run(List<String> strings)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        StringBuffer commaAndSpaceSeparatedList = new StringBuffer();

        for(int i = 0; i < strings.size(); i++)
        {

            if(StringsService.isNotEmpty(strings.get(i)))
            {
                commaAndSpaceSeparatedList.append(strings.get(i));

                if(i < strings.size() - 1)
                {
                    commaAndSpaceSeparatedList.append(", ");
                }

            }

        }

        return commaAndSpaceSeparatedList.toString();
    }
}
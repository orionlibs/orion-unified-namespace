package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.string.StringsService;
import java.util.List;

public class SeparateByStringTask extends Orion
{
    public static String run(List<String> strings, String separator)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        Assert.notEmpty(separator, "The separator input cannot be null/empty.");
        StringBuffer separatedList = new StringBuffer();

        for(int i = 0; i < strings.size(); i++)
        {

            if(StringsService.isNotEmpty(strings.get(i)))
            {
                separatedList.append(strings.get(i));

                if(i < strings.size() - 1)
                {
                    separatedList.append(separator);
                }

            }

        }

        return separatedList.toString();
    }
}
package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.string.builder.StringBuilderService;
import java.util.Arrays;
import java.util.Collection;

public class ConcatenateTask extends Orion
{
    public static String run(String... strings)
    {
        return run(Arrays.asList(strings));
    }


    public static String run(Collection<String> strings)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        final StringBuilderService stringBuilderService = new StringBuilderService();

        if(strings != null)
        {
            strings.forEach(aString -> stringBuilderService.add(aString));
        }

        return stringBuilderService.toString();
    }
}
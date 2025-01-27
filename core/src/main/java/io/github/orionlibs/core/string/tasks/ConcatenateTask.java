package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.string.builder.StringBuilderService;
import java.util.Arrays;
import java.util.Collection;

public class ConcatenateTask
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
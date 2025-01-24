package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;

public class PrefixStringTask extends Orion
{
    public static String run(String s, String prefix)
    {
        Assert.notNull(s, "The main string input cannot be null.");
        Assert.notNull(prefix, "The prefix input cannot be null.");
        return prefix + s;
    }
}
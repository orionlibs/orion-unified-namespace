package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.exception.Assert;

public class PrefixStringTask
{
    public static String run(String s, String prefix)
    {
        Assert.notNull(s, "The main string input cannot be null.");
        Assert.notNull(prefix, "The prefix input cannot be null.");
        return prefix + s;
    }
}
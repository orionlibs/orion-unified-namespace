package io.github.orionlibs.core.string.tasks;

import java.util.stream.IntStream;

public class IsOnlyAlphabeticalTask
{
    public static boolean run(String s)
    {
        if(s != null && !s.isEmpty())
        {
            return !IntStream.range(0, s.length()).anyMatch(i -> !Character.isLetter(s.charAt(i)));
        }
        else
        {
            return false;
        }
    }
}
package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoesMatchRegularExpressionTask extends Orion
{
    public static boolean run(String s, String regularExpression)
    {

        if(s != null && !s.isEmpty())
        {

            try
            {
                final Pattern r = Pattern.compile(regularExpression);
                final Matcher m = r.matcher(s);
                return m.matches();
            }
            catch(final Exception e)
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}
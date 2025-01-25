package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.operating_system.OperatingSystemService;

public class DeleteLineSeparatorFromTheEndTask extends Orion
{
    public static String run(String aString)
    {
        Assert.notEmpty(aString, "The aString input cannot be null/empty.");

        if(aString.endsWith(System.lineSeparator()))
        {

            if(OperatingSystemService.isLinuxSystem() || OperatingSystemService.isMacOSXSystem())
            {
                return aString.substring(0, aString.length() - 2);
            }
            else if(OperatingSystemService.isWindowsSystem())
            {
                return aString.substring(0, aString.length() - 4);
            }

        }

        return aString;
    }
}
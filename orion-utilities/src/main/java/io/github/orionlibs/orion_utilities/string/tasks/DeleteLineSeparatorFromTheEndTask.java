package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.operating_system.OperatingSystemService;

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
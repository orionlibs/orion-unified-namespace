package io.github.orionlibs.utilities.net.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;

public class ConvertByteWithoutOverflowingToStringTask extends Orion
{
    public static String run(String IPAddressString, byte aByte)
    {

        if(aByte < 0)
        {
            IPAddressString += (aByte + 256);
        }
        else
        {
            IPAddressString += Byte.toString(aByte);
        }

        return IPAddressString;
    }
}
package io.github.orionlibs.core.net.tasks;

public class ConvertByteWithoutOverflowingToStringTask
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
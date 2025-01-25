package io.github.orionlibs.core.net.tasks;

public class ConvertStringToByteWithoutOverflowingTask
{
    public static void run(byte[] IPAddressTemp, short aByte, int i)
    {
        if(aByte > Byte.MAX_VALUE)
        {
            aByte -= 256;
        }
        IPAddressTemp[i] = Byte.parseByte(Short.toString(aByte));
    }
}
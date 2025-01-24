package io.github.orionlibs.orion_utilities.numerical_base.hexadecimal;

import io.github.orionlibs.orion_utilities.abstraction.OrionService;
import io.github.orionlibs.orion_utilities.numerical_base.hexadecimal.tasks.ConvertToHexadecimalBaseTask;

public class HexadecimalService extends OrionService
{
    public static String convertToHexadecimalBase(String data)
    {
        return ConvertToHexadecimalBaseTask.run(data.getBytes());
    }


    public static String convertToHexadecimalBase(byte[] data)
    {
        return ConvertToHexadecimalBaseTask.run(data);
    }
}
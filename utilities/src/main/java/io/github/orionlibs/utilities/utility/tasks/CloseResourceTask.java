package io.github.orionlibs.utilities.utility.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import java.io.Closeable;
import java.io.IOException;

public class CloseResourceTask extends Orion
{
    public static boolean run(Closeable closeable)
    {

        if(closeable != null)
        {
            return closeResource(closeable);
        }

        return false;
    }


    private static boolean closeResource(Closeable closeable)
    {

        try
        {
            closeable.close();
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }

    }
}
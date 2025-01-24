package io.github.orionlibs.orion_utilities.math.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

public class GetRandomIntegerExceptZeroTask extends Orion
{
    public static int run(int maximumNumber)
    {
        int randomNumber = 0;

        do
        {
            randomNumber = (int)(Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber == 0);

        return randomNumber;
    }


    public static int run(int minimumNumber, int maximumNumber)
    {
        int randomNumber = 0;

        do
        {
            randomNumber = (int)(Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber < minimumNumber);

        return randomNumber;
    }
}
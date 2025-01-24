package io.github.orionlibs.orion_utilities.math;

import io.github.orionlibs.orion_utilities.abstraction.OrionService;
import io.github.orionlibs.orion_utilities.math.tasks.GetRandomIntegerExceptZeroTask;
import io.github.orionlibs.orion_utilities.math.tasks.GetRandomNumberExceptZeroTask;

public class RandomNumberGenerationService extends OrionService
{
    public static double getRandomNumberFromZeroToOne()
    {
        return Math.random();
    }


    public static int getRandomInteger(int maximumNumber)
    {
        return (int)(Math.floor(Math.random() * maximumNumber));
    }


    public static double getRandomInteger(double maximumNumber)
    {
        return (int)(Math.floor(Math.random() * maximumNumber));
    }


    public static int getRandomIntegerExceptZero(int maximumNumber)
    {
        return GetRandomIntegerExceptZeroTask.run(maximumNumber);
    }


    public static double getRandomNumberExceptZero(double maximumNumber)
    {
        return GetRandomNumberExceptZeroTask.run(maximumNumber);
    }


    public static int getRandomIntegerExceptZero(int minimumNumber, int maximumNumber)
    {
        return GetRandomIntegerExceptZeroTask.run(minimumNumber, maximumNumber);
    }


    public static double getRandomNumberExceptZero(double minimumNumber, double maximumNumber)
    {
        return GetRandomNumberExceptZeroTask.run(minimumNumber, maximumNumber);
    }
}
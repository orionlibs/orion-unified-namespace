package io.github.orionlibs.core.abstraction;

import io.github.orionlibs.core.profile.Profile;
import java.io.Serializable;

public abstract class Orion implements Serializable
{
    public static String systemProfileMode = "localhost";
    public static String domainName = "localhost";


    public static boolean isTesting()
    {
        return Profile.TestingProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotTesting()
    {
        return !isTesting();
    }


    public static boolean isLocalhost()
    {
        return Profile.LocalhostProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotLocalhost()
    {
        return !isLocalhost();
    }


    public static boolean isDev()
    {
        return Profile.DevProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotDev()
    {
        return !isDev();
    }


    public static boolean isProduction()
    {
        return Profile.ProductionProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotProduction()
    {
        return !isProduction();
    }
}
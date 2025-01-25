package io.github.orionlibs.core.registry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceRegistry
{
    public static final ConcurrentMap<Class<?>, Object> services;

    static
    {
        services = new ConcurrentHashMap<>();
    }

    public static void registerService(Class<?> classType, Object service)
    {
        for(Class<?> clazz : service.getClass().getClasses())
        {
            if(clazz.getName().equals(classType.getName()))
            {
                services.put(classType, service);
            }
        }
    }


    public static Object getService(Class<?> classType)
    {
        return services.get(classType);
    }
}

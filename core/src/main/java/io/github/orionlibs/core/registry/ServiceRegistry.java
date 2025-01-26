package io.github.orionlibs.core.registry;

import io.github.orionlibs.core.abstraction.OrionRegistry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceRegistry implements OrionRegistry
{
    private static final ConcurrentMap<Class<?>, Object> services;

    static
    {
        services = new ConcurrentHashMap<>();
    }

    public static void registerService(Class<?> classType, Object service)
    {
        if(classType.isAssignableFrom(service.getClass()))
        {
            services.put(classType, service);
        }
    }


    public static Object getService(Class<?> classType)
    {
        return services.get(classType);
    }
}

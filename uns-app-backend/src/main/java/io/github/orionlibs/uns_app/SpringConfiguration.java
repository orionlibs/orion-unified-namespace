package io.github.orionlibs.uns_app;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.InMemoryConfigurationService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

@Configuration
public class SpringConfiguration
{
    @Autowired
    public SpringConfiguration(Environment env)
    {
        loadSpringProfile(env.getActiveProfiles());
        InMemoryConfigurationService.registerProp("default.timezone.for.printing", "GB");
        for(PropertySource<?> propertySource : ((AbstractEnvironment)env).getPropertySources())
        {
            if(propertySource instanceof EnumerablePropertySource)
            {
                String[] propertyNames = ((EnumerablePropertySource<?>)propertySource).getPropertyNames();
                Arrays.stream(propertyNames)
                                .forEach(prop -> InMemoryConfigurationService.registerProp(prop, env.getProperty(prop)));
            }
        }
    }


    private static void loadSpringProfile(String[] activeProfiles)
    {
        if(activeProfiles == null || activeProfiles.length == 0)
        {
            System.setProperty("active.execution.profile", OrionDomain.production);
            Orion.domainName = OrionDomain.production;
        }
        else
        {
            for(String profileName : activeProfiles)
            {
                Orion.systemProfileMode = profileName;
                if(Orion.isLocalhost())
                {
                    Orion.domainName = OrionDomain.localhost;
                }
                else if(Orion.isTesting())
                {
                    Orion.domainName = OrionDomain.testing;
                }
                else if(Orion.isDev())
                {
                    Orion.domainName = OrionDomain.dev;
                }
                else if(Orion.isProduction())
                {
                    Orion.domainName = OrionDomain.production;
                }
                System.setProperty("active.execution.profile", Orion.domainName);
                break;
            }
        }
    }
}
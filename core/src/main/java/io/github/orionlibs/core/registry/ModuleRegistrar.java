package io.github.orionlibs.core.registry;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ModuleRegistrar
{
    private final ApplicationContext applicationContext;


    public ModuleRegistrar(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }


    public void registerModules()
    {
        Map<String, Object> modules = applicationContext.getBeansWithAnnotation(Module.class);
        modules.forEach((beanName, bean) -> {
            Module moduleAnnotation = bean.getClass().getAnnotation(Module.class);
            ModuleRegistry.register(moduleAnnotation.name(), moduleAnnotation.version());
        });
    }
}

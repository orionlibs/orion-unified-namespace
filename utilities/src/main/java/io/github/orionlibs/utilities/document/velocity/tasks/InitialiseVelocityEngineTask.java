package io.github.orionlibs.utilities.document.velocity.tasks;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class InitialiseVelocityEngineTask
{
    public static VelocityEngine run()
    {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setProperty("runtime.log.logsystem.class", NullLogChute.class.getName());
        velocityEngine.init();
        return velocityEngine;
    }
}
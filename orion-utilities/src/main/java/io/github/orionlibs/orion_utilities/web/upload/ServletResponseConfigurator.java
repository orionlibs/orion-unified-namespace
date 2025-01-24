package io.github.orionlibs.orion_utilities.web.upload;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

class ServletResponseConfigurator extends Orion
{
    static void configure(ServletResponseConfiguration configuration)
    {
        configuration.getResponse().setContentType(configuration.getMIMEType());
        configuration.getResponse().addHeader("Content-Disposition", "attachment; filename=" + configuration.getFileNameForClient());
        configuration.getResponse().setContentLength(configuration.getContentLength());
    }
}
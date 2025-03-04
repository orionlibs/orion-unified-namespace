package io.github.orionlibs.core.web.upload;

class ServletResponseConfigurator
{
    static void configure(ServletResponseConfiguration configuration)
    {
        configuration.getResponse().setContentType(configuration.getMIMEType());
        configuration.getResponse().addHeader("Content-Disposition", "attachment; filename=" + configuration.getFileNameForClient());
        configuration.getResponse().setContentLength(configuration.getContentLength());
    }
}
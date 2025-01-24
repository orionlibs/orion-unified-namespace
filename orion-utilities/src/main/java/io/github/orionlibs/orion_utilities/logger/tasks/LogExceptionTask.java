package io.github.orionlibs.orion_utilities.logger.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.configuration.InMemoryConfigurationService;
import io.github.orionlibs.orion_utilities.exception.ExceptionService;
import io.github.orionlibs.orion_utilities.runnable.OrionJob;

public class LogExceptionTask extends Orion implements OrionJob
{
    private String errorMessage;
    private Throwable exception;
    private Object[] parameters;


    public LogExceptionTask(String errorMessage, Throwable exception, Object... parameters)
    {
        this.errorMessage = errorMessage;
        this.exception = exception;
        this.parameters = parameters;
    }


    public void run()
    {
        boolean logToTomcat = InMemoryConfigurationService.getBooleanProp("error.logging.to.tomcat.enable");
        boolean logToDatabase = InMemoryConfigurationService.getBooleanProp("error.logging.to.database.enable");

        if(logToTomcat || logToDatabase)
        {
            String errorMessageTemp = "";

            if(parameters != null && parameters.length > 0)
            {
                errorMessageTemp += String.format(errorMessage, parameters);
            }
            else
            {
                errorMessageTemp += errorMessage;
            }

            if(exception != null)
            {
                errorMessageTemp += ExceptionService.getAllErrorMessagesFromTheHierarchy(exception);
            }

            if(logToTomcat)
            {
                logErrorToConsole(errorMessageTemp);
            }
        }

    }
}
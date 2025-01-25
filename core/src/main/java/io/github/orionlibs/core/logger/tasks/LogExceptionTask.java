package io.github.orionlibs.core.logger.tasks;

import io.github.orionlibs.core.configuration.InMemoryConfigurationService;
import io.github.orionlibs.core.exception.ExceptionService;
import io.github.orionlibs.core.logger.ConsoleLoggerService;
import io.github.orionlibs.core.runnable.OrionJob;

public class LogExceptionTask implements OrionJob
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
                ConsoleLoggerService.logError(errorMessageTemp, parameters);
            }
        }
    }
}
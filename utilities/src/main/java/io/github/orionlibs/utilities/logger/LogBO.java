package io.github.orionlibs.utilities.logger;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.logger.tasks.LogExceptionTask;
import io.github.orionlibs.utilities.logger.tasks.LogUserActionTask;
import io.github.orionlibs.utilities.runnable.OrionJobService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class LogBO extends Orion
{
    private String userID;
    private String actionType;
    private String actionDescription;
    private HttpServletRequest request;
    private String IPAddress;
    private String errorType;
    private String errorMessage;
    private Throwable exception;
    private Object[] parameters;


    public void logActionWithHTTPRequest()
    {
        try
        {
            LogUserActionTask logUserActionTask = new LogUserActionTask(userID, actionType, actionDescription);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }
    }


    public void logActionWithoutHTTPRequest()
    {
        try
        {
            LogUserActionTask logUserActionTask = new LogUserActionTask(userID, actionType, actionDescription);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }
    }


    public void logActionWithoutUserID()
    {
        try
        {
            LogUserActionTask logUserActionTask = new LogUserActionTask(null, actionType, actionDescription);
            OrionJobService.runJob(logUserActionTask);
        }
        catch(Exception e)
        {
        }
    }


    public void logErrorWithException()
    {
        try
        {
            LogExceptionTask logExceptionTask = new LogExceptionTask(errorMessage, exception, parameters);
            OrionJobService.runJob(logExceptionTask);
        }
        catch(Exception e)
        {
        }
    }
}
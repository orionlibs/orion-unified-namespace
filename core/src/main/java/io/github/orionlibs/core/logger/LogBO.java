package io.github.orionlibs.core.logger;

import io.github.orionlibs.core.logger.tasks.LogExceptionTask;
import io.github.orionlibs.core.logger.tasks.LogUserActionTask;
import io.github.orionlibs.core.runnable.OrionJobService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class LogBO
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
package io.github.orionlibs.core.logger;

import jakarta.servlet.http.HttpServletRequest;

public class LoggingService
{
    public static void logAction(String userID, String actionType, String actionDescription, HttpServletRequest request)
    {
        LogBO.builder()
                        .userID(userID)
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .request(request)
                        .build().logActionWithHTTPRequest();
    }


    public static void logAction(String userID, String actionType, String actionDescription)
    {
        LogBO.builder()
                        .userID(userID)
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .build().logActionWithoutHTTPRequest();
    }


    public static void logAction(String actionType, String actionDescription)
    {
        LogBO.builder()
                        .actionType(actionType)
                        .actionDescription(actionDescription)
                        .build().logActionWithoutUserID();
    }


    public static void logError(Throwable exception, String IPAddress, String userID, String errorType, String errorMessage, Object... parameters)
    {
        LogBO.builder()
                        .IPAddress(IPAddress)
                        .userID(userID)
                        .errorType(errorType)
                        .errorMessage(errorMessage)
                        .exception(exception)
                        .parameters(parameters)
                        .build()
                        .logErrorWithException();
    }
}
package io.github.orionlibs.core.exception;

import io.github.orionlibs.core.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}
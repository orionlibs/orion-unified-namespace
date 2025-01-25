package io.github.orionlibs.utilities.exception;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService extends OrionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}
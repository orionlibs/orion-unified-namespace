package io.github.orionlibs.orion_utilities.exception;

import io.github.orionlibs.orion_utilities.abstraction.OrionService;
import io.github.orionlibs.orion_utilities.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService extends OrionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}
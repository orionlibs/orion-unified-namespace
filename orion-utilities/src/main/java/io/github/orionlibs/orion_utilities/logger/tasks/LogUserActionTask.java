package io.github.orionlibs.orion_utilities.logger.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.configuration.InMemoryConfigurationService;
import io.github.orionlibs.orion_utilities.runnable.OrionJob;

public class LogUserActionTask extends Orion implements OrionJob
{
    private String userID;
    private String actionType;
    private String actionDescription;


    public LogUserActionTask(String userID, String actionType, String actionDescription)
    {
        this.userID = userID;
        this.actionType = actionType;
        this.actionDescription = actionDescription;
    }


    public void run()
    {
        boolean logToTomcat = InMemoryConfigurationService.getBooleanProp("action.logging.to.tomcat.enable");
        boolean logToDatabase = InMemoryConfigurationService.getBooleanProp("action.logging.to.database.enable");
        if(logToTomcat || logToDatabase)
        {
            if(logToTomcat)
            {
                logToConsole("userID = " + userID + " -- ActionType = " + actionType + " -- " + actionDescription);
            }
        }
    }
}
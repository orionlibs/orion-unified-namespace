package io.github.orionlibs.core.logger.tasks;

import io.github.orionlibs.core.configuration.Config;
import io.github.orionlibs.core.logger.ConsoleLoggerService;
import io.github.orionlibs.core.runnable.OrionJob;

public class LogUserActionTask implements OrionJob
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
        boolean logToTomcat = Config.getBooleanProp("action.logging.to.tomcat.enable");
        boolean logToDatabase = Config.getBooleanProp("action.logging.to.database.enable");
        if(logToTomcat || logToDatabase)
        {
            if(logToTomcat)
            {
                ConsoleLoggerService.log("userID = " + userID + " -- ActionType = " + actionType + " -- " + actionDescription);
            }
        }
    }
}
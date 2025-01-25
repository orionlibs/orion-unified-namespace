package io.github.orionlibs.utilities.web.emailer.template;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.calendar.CalendarService;
import io.github.orionlibs.utilities.uuid.UUIDSecurityService;
import java.util.HashMap;
import java.util.Map;

public class InitialEmailTemplateParametersProvider extends Orion
{
    public static Map<String, String> initialiseTemplateParameters()
    {
        return generateInitialTemplateParameters();
    }


    private static Map<String, String> generateInitialTemplateParameters()
    {
        Map<String, String> templateParameters = new HashMap<>();
        templateParameters.put("emailID", UUIDSecurityService.generateUUIDWithoutHyphens());
        templateParameters.put("currentYear", Integer.toString(CalendarService.getCurrentYear()));
        return templateParameters;
    }
}
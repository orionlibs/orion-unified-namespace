package io.github.orionlibs.orion_utilities.web.emailer.template;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.configuration.InMemoryConfigurationService;
import io.github.orionlibs.orion_utilities.cryptology.encoding.base64.Base64EncodingService;

public class EmailTemplateResolver extends Orion
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = InMemoryConfigurationService.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}
package io.github.orionlibs.utilities.web.emailer.template;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.configuration.InMemoryConfigurationService;
import io.github.orionlibs.utilities.cryptology.encoding.base64.Base64EncodingService;

public class EmailTemplateResolver extends Orion
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = InMemoryConfigurationService.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}
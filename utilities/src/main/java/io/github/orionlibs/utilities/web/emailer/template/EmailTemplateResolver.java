package io.github.orionlibs.utilities.web.emailer.template;

import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;

public class EmailTemplateResolver
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = ConfigurationService.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}
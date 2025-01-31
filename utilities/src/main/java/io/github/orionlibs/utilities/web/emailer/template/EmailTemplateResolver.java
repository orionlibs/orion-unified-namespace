package io.github.orionlibs.utilities.web.emailer.template;

import io.github.orionlibs.core.configuration.Config;
import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;

public class EmailTemplateResolver
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = Config.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}
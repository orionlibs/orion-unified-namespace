package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.document.velocity.VelocityTemplateService;
import io.github.orionlibs.utilities.web.emailer.template.EmailTemplateDefaults;
import io.github.orionlibs.utilities.web.emailer.template.EmailTemplateResolver;
import java.util.Map;

public class EmailDataPopulator extends Orion
{
    public static EmailData populate(Map<String, String> templateParameters, String velocityTemplateID, String velocityTemplateName, String emailSubject, String emailRecipient, String emailSender, String emailSenderName)
    {
        String decodedHTMLTemplate = EmailTemplateResolver.resolve(velocityTemplateID);
        String templateBody = VelocityTemplateService.getVelocityTemplateAsString(templateParameters, velocityTemplateName, decodedHTMLTemplate);
        return EmailData.builder()
                        .emailID(templateParameters.get("emailID"))
                        .emailMessage(templateBody)
                        .emailRecipient(emailRecipient)
                        .emailSender(emailSender)
                        .emailSenderName(emailSenderName)
                        .emailSubject(emailSubject)
                        .messageMIMEType(EmailTemplateDefaults.messageMIMEType)
                        .build();
    }
}
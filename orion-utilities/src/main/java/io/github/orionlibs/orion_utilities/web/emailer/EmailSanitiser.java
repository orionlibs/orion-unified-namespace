package io.github.orionlibs.orion_utilities.web.emailer;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.content.MIMEType;

class EmailSanitiser extends Orion
{
    static void sanitise(EmailData emailData)
    {

        if(emailData.isReplaceNewLineWithBreakLine() && MIMEType.HTML_UTF8.equals(emailData.getMessageMIMEType()))
        {
            emailData.setEmailMessage(emailData.getEmailMessage().replace("\n", "<br>"));
        }

    }
}
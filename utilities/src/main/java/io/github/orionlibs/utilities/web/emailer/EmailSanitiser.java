package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.content.MIMEType;

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
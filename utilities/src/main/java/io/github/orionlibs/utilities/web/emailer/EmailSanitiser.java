package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.core.content.MIMEType;

class EmailSanitiser
{
    static void sanitise(EmailData emailData)
    {

        if(emailData.isReplaceNewLineWithBreakLine() && MIMEType.HTML_UTF8.equals(emailData.getMessageMIMEType()))
        {
            emailData.setEmailMessage(emailData.getEmailMessage().replace("\n", "<br>"));
        }

    }
}
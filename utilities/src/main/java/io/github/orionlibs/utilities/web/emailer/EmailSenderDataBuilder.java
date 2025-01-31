package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.core.configuration.Config;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;

class EmailSenderDataBuilder
{
    static EmailSenderData build(Session emailSession, MimeMessage messageToSend) throws NoSuchProviderException
    {
        return EmailSenderData.builder()
                        .transport(emailSession.getTransport("smtp"))
                        .messageToSend(messageToSend)
                        .SMTPHost(Config.getProp("email.administrator.email.address.smtp.host"))
                        .emailAccountUsername(Config.getProp("email.administrator.email.address.username"))
                        .emailAccountPassword(Config.getProp("email.administrator.email.address.password"))
                        .build();
    }
}
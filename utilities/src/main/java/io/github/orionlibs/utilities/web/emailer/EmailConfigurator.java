package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.core.configuration.Config;
import java.util.Properties;

class EmailConfigurator
{
    static Properties getEmailParameters()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.setProperty("mail.transport.protocol", "smtp");
        emailProperties.setProperty("administrator.mail.smtp.starttls.enable", "true");
        emailProperties.setProperty("email.administrator.email.address.smtp.host", Config.getProp("email.administrator.email.address.smtp.host"));
        emailProperties.setProperty("email.administrator.email.address.smtp.port", Config.getProp("email.administrator.email.address.smtp.port"));
        emailProperties.setProperty("email.administrator.email.address.smtp.auth", Config.getProp("email.administrator.email.address.smtp.auth"));
        return emailProperties;
    }
}
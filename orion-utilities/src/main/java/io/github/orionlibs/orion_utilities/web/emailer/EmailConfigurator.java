package io.github.orionlibs.orion_utilities.web.emailer;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.configuration.InMemoryConfigurationService;
import java.util.Properties;

class EmailConfigurator extends Orion
{
    static Properties getEmailParameters()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.setProperty("mail.transport.protocol", "smtp");
        emailProperties.setProperty("administrator.mail.smtp.starttls.enable", "true");
        emailProperties.setProperty("email.administrator.email.address.smtp.host", InMemoryConfigurationService.getProp("email.administrator.email.address.smtp.host"));
        emailProperties.setProperty("email.administrator.email.address.smtp.port", InMemoryConfigurationService.getProp("email.administrator.email.address.smtp.port"));
        emailProperties.setProperty("email.administrator.email.address.smtp.auth", InMemoryConfigurationService.getProp("email.administrator.email.address.smtp.auth"));
        return emailProperties;
    }
}
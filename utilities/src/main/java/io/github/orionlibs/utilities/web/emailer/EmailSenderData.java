package io.github.orionlibs.utilities.web.emailer;

import io.github.orionlibs.utilities.abstraction.Orion;
import jakarta.mail.Transport;
// import com.sun.mail.smtp.SMTPTransport;
import jakarta.mail.internet.MimeMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmailSenderData extends Orion
{
    private Transport transport;
    private MimeMessage messageToSend;
    private String SMTPHost;
    private String emailAccountUsername;
    private String emailAccountPassword;
}
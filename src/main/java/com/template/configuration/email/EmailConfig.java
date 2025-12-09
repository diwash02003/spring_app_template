package com.template.configuration.email;

import com.template.constants.EmailDataConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author diwash
 * @created 12/9/25
 */

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(EmailDataConstant.HOST);
        mailSender.setPort(EmailDataConstant.PORT);
        mailSender.setUsername(EmailDataConstant.SENDER_EMAIL);
        mailSender.setPassword(EmailDataConstant.EMAIL_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put(EmailDataConstant.SMTP_AUTH_KEY, EmailDataConstant.SMTP_AUTH_VALUE);
        props.put(EmailDataConstant.PROTOCOL_KEY, EmailDataConstant.PROTOCOL_VALUE);
        props.put(EmailDataConstant.SMTP_STARTTLS_KEY, EmailDataConstant.SMTP_STARTTLS_VALUE);
        props.put(EmailDataConstant.MAIL_DEBUG_KEY, EmailDataConstant.MAIL_DEBUG_VALUE);

        return mailSender;
    }
}

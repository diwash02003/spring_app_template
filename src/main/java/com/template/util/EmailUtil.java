package com.template.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.activation.DataHandler;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.InputStream;
import java.net.URLConnection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author diwash
 * @created 12/9/25
 */

@Component
@Slf4j
public class EmailUtil {
    private final JavaMailSender javaMailSender;
    private final Configuration freemarkerConfig;

    @Autowired
    public EmailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

        // FreeMarker configuration
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
        this.freemarkerConfig.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/templates"));
        this.freemarkerConfig.setDefaultEncoding("UTF-8");
    }

    public synchronized void send(String subject, String receiver, Map<String, Object> model, String templateName) {
        try {

            Template template = freemarkerConfig.getTemplate(templateName);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMultipart content = buildEmailContent(html);

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(receiver);
            helper.setSubject(subject);
            message.setContent(content);

            javaMailSender.send(message);

        } catch (Exception e) {
            log.error("EMAIL SENDING FAILED: {}", e.getMessage(), e);
        }
    }

    private MimeMultipart buildEmailContent(String html) throws Exception {

        MimeMultipart multipart = new MimeMultipart("related");

        // HTML part
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(html, "text/html; charset=UTF-8");
        multipart.addBodyPart(htmlPart);

        // Regex for inline images
        Pattern pattern = Pattern.compile("src=\"cid:([^\"]+)\"");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {

            String imageName = matcher.group(1);
            String classpathLocation = "/static/images/" + imageName;

            log.debug("Checking image: {}", classpathLocation);

            // Load as InputStream (SAFE for JAR)
            InputStream inputStream = getClass().getResourceAsStream(classpathLocation);

            if (inputStream == null) {
                log.warn("Inline image NOT FOUND: {}", classpathLocation);
                continue;
            }

            // Guess MIME type
            String mimeType = URLConnection.guessContentTypeFromName(imageName);
            if (mimeType == null) mimeType = "image/png";

            // Create Inline Image Part
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(inputStream, mimeType)));
            imagePart.setHeader("Content-ID", "<" + imageName + ">");
            imagePart.setFileName(imageName);

            multipart.addBodyPart(imagePart);
            inputStream.close();
        }

        return multipart;
    }
}

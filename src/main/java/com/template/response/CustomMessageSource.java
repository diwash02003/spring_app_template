package com.template.response;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

/**
 * @author diwash
 * @created 12/9/25
 */

@Component
public class CustomMessageSource {
    private final MessageSource messageSource;

    public CustomMessageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource
                = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasenames("classpath:message");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        reloadableResourceBundleMessageSource.setCacheSeconds(5);
        this.messageSource = reloadableResourceBundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(this.messageSource);
        return bean;
    }

    public String get(String code) {
        try {
            return messageSource.getMessage(code, null, getCurrentLocale());
        } catch (NoSuchMessageException e) {
            return code;
        }
    }

    public String get(String code, Object... objects) {
        return messageSource.getMessage(code, objects, getCurrentLocale());
    }

    public Locale getCurrentLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getDisplayLanguage().equalsIgnoreCase("np")) {
            locale = Locale.forLanguageTag("np");
        }
        return locale;
    }
}

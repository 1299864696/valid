package com.xkt.valid.config.valid;

import cn.hutool.extra.spring.SpringUtil;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.Properties;


@Configuration
public class ValidationConfiguration {

    /**
     * 参考 {@link ValidationAutoConfiguration #defaultValidator()} 方法，构建 Validator Bean
     *
     * @return Validator 对象
     */
    @Bean
    public Validator validator(MessageSource messageSource) {
        LocalValidatorFactoryBean factoryBean = ValidationAutoConfiguration.defaultValidator(SpringUtil.getApplicationContext());
        // 设置上方配置的国际化源
        factoryBean.setValidationMessageSource(messageSource);
        // 设置使用 HibernateValidator 校验器
        factoryBean.setProviderClass(HibernateValidator.class);
        Properties properties = new Properties();
        // 设置 快速异常返回
        properties.setProperty("hibernate.validator.fail_fast", "true");
        factoryBean.setValidationProperties(properties);
        // 加载配置
        factoryBean.afterPropertiesSet();
        return factoryBean.getValidator();
    }
}

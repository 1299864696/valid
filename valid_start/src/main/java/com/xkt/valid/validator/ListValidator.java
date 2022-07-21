/*package com.xkt.valid.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.List;

@Component
public class ListValidator implements Validator {
    @Autowired
    private LocalValidatorFactoryBean validator;

    @Override
    public boolean supports(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        List<?> list = (List<?>)target;
        for (Object o: list) {
            validator.validate(o, errors);
        }
    }

}*/

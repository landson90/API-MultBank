package com.example.app.multbanck.multbank.config.validator.customized;

import com.example.app.multbanck.multbank.config.validator.customized.implementation.ClientInsertValidator;
import com.example.app.multbanck.multbank.config.validator.customized.implementation.ClientUpdateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClientUpdateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientUpdate {
    String message() default "Erro de validação";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

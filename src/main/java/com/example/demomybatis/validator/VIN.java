package com.example.demomybatis.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = VINValidator.class)
@Documented
public @interface VIN {

    String message() default "VIN is not allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
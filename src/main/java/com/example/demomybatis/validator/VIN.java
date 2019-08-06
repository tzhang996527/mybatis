package com.example.demomybatis.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD}) //指定应用该注解的声明类型
@Retention(RUNTIME)//使用RUNTIME保留策略的注解，不仅被保留在.class文件中，
                    // 而且在运行时能够通过JVM得到这些注解。因此，RUNTIME提供了永久的注解。
@Constraint(validatedBy = VINValidator.class)
@Documented //告诉工具注解被文档化
public @interface VIN {

    String message() default "VIN is not allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
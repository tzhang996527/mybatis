package com.example.demomybatis.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class VINValidator implements ConstraintValidator<VIN, String> {

    List<String> VINs = Arrays.asList("V1", "V2", "V3", "V4");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return VINs.contains(value);

    }
}

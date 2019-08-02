package com.example.demomybatis.validator;

import com.example.demomybatis.entity.Asset;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AssetValidator implements Validator {
    /**
     * This Validator validates *only* Person instances
     */
    public boolean supports(Class clazz) {
        return Asset.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e,"vin", "vin.empty");
        Asset p = (Asset) obj;
        if (p.getPlatenumber().equals("12345")) {
            e.rejectValue("platenumber","error:12345");
        }
    }
}

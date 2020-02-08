package com.app.myorder.api.validations;

import com.app.myorder.api.dtos.user.CreateUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordValidator, Object> {

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        CreateUserDto user = (CreateUserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}


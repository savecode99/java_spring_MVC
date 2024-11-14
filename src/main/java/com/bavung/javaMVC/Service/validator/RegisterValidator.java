package com.bavung.javaMVC.Service.validator;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Service.UserService;
import com.bavung.javaMVC.model.RegisterDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {

    private UserService userService;
    public RegisterValidator(UserService userService)
    {
        this.userService = userService;
    }
    

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check if password fields match
        if (!user.getPassWord().equals(user.getConfirmPassWord())) {
            context.buildConstraintViolationWithTemplate("Vui lòng nhập chính xác")
                    .addPropertyNode("confirmPassWord")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Additional validations can be added here
        if(this.userService.checkExistEmail(user.getEmail()))
        {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        return valid;
    }
}

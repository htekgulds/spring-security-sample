package tr.gov.tuik.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tr.gov.tuik.spring.domain.UserCreateForm;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Component
public class UserCreateFormValidator implements Validator {

    private UserService userService;

    @Inject
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeat())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("emails.exists", "User with this email already exists");
        }
    }
}

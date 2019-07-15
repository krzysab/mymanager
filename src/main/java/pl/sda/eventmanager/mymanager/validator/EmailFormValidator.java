package pl.sda.eventmanager.mymanager.validator;

import org.springframework.validation.Validator;
import pl.sda.eventmanager.mymanager.dto.EmailForm;
import org.springframework.validation.Errors;

public class EmailFormValidator implements Validator {

    private static final String EMAIL_NOT_GMAIL = "email.notGmail";

    @Override
    public boolean supports(Class<?> aClass) {
        return EmailForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmailForm form = (EmailForm) o;
        if (!form.getEmail().endsWith("gmail.com")) {
            errors.rejectValue("email", EMAIL_NOT_GMAIL, "Not in gmail domain");
        }
    }
}

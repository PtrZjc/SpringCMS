package pl.zajacp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements
        ConstraintValidator<StartWith, String> {
    private String start;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        this.start = constraintAnnotation.value();
    }
    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        return value.startsWith(start);
    }
}


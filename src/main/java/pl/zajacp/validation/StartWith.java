package pl.zajacp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartWithValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface StartWith {
   String value();
   String message() default "{startWith.error.message}";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {}; }
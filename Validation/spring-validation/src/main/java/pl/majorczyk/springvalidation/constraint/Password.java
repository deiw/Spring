package pl.majorczyk.springvalidation.constraint;

import pl.majorczyk.springvalidation.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "Password is not correct";
    Class<?>[]groups() default {};
    Class<? extends Payload>[]payload()default {};

    int min() default 0;
    int max() default 0;
}

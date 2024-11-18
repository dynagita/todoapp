package com.example.todoapp.Utils.CustomAttributes.Validators;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateBeforeValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateBefore {
    String message() default "Date must be before {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String value();
}

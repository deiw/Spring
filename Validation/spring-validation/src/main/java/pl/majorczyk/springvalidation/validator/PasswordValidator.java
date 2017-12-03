package pl.majorczyk.springvalidation.validator;

import pl.majorczyk.springvalidation.constraint.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    private int min;
    private int max;

    @Override
    public void initialize(Password password) {
        this.min=password.min();
        this.max=password.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid=true;
        if(min!=0){
            valid &=checkMin(s);
        }
        if(max!=0) {
            valid &= checkMax(s);
        }
        if(s.toLowerCase().equals(s)){
            valid &=false;
        }
        valid&=checkDigits(s);

        return valid;
    }
    private boolean checkMin(String s){
        return s.length() >= min;
    }
    private boolean checkMax(String s){
        return s.length()<=max;
    }
    private boolean checkDigits(String s){
        boolean result=false;
        for(int i=0;i<s.length();i++){
            if(s.codePointAt(i)<58&&s.codePointAt(i)>47) result=true;
        }
        return result;
    }

}

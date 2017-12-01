package pl.majorczyk.springvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.majorczyk.springvalidation.model.User;
import pl.majorczyk.springvalidation.repository.UserRepository;


@Service
public class UserService {

    private Validator validator;
    private UserRepository userRepo;

    @Autowired
    public UserService(Validator validator, UserRepository userRepo) {
        this.validator = validator;
        this.userRepo=userRepo;

    }
    public Errors addUser(User user){
        Errors errors=new BeanPropertyBindingResult(user,"user");
        validator.validate(user,errors);
        if(!errors.hasErrors()) userRepo.save(user);
        return errors;
    }
}

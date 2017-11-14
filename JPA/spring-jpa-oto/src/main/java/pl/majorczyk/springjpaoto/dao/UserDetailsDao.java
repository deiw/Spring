package pl.majorczyk.springjpaoto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springjpaoto.model.UserDetails;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDao {

    @Autowired
    EntityManager em;

    public UserDetails read(Long id){
        UserDetails details=em.find(UserDetails.class,id);
        return details;
    }
}

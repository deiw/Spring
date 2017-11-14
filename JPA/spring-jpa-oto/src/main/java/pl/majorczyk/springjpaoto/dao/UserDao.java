package pl.majorczyk.springjpaoto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpaoto.model.User;
import pl.majorczyk.springjpaoto.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public void create(User user){
        UserDetails details=user.getDetails();
        if(details!=null&&details.getId()==null){
            em.persist(details);
        }
        em.persist(user);
    }
    public User read(Long id){
       User result= em.find(User.class,id);
       return result;
    }
    public void update(User user){
        UserDetails details=user.getDetails();
        if(details!=null){
            details=em.merge(details);
            user.setDetails(details);
        }
        em.merge(user);
    }
    public void delete(User user){
        User result=em.merge(user);
        em.remove(result.getDetails());
        em.remove(result);
    }
}

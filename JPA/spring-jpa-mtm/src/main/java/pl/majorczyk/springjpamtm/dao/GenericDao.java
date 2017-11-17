package pl.majorczyk.springjpamtm.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;


@Transactional
public abstract class GenericDao<T,K> {

    @PersistenceContext
    private EntityManager em;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    GenericDao(){
        type=(Class<T>)((ParameterizedType)this.getClass()
        .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }


    public void save(T entity){
        em.persist(entity);
    }
    public T get(K id){
        T obj=em.find(type,id);
        return obj;
    }
}

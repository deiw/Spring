package pl.majorczyk.springjpadynamicqueries.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpadynamicqueries.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Product product){
        entityManager.persist(product);
    }
    public Product get(Long id){
        Product product=entityManager.find(Product.class,id);
        return product;
    }
    public List<Product> getAll(){
        final String getAll="SELECT p FROM Product p";
        TypedQuery<Product>query=entityManager.createQuery(getAll,Product.class);
        List<Product> list=query.getResultList();
        return list;
    }
    public void removeAll(){
        final String removeAll="DELETE FROM Product p";
        Query deleteAllQuery=entityManager.createQuery(removeAll);
        deleteAllQuery.executeUpdate();
    }
    public List<Product> customGet(String jpqlQuery){
        TypedQuery<Product> customs=entityManager.createQuery(jpqlQuery,Product.class);
        List<Product>list=customs.getResultList();
        return list;
    }

}

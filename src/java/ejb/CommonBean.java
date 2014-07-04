/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.CommonEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @param <T> 
 * @author Lei
 */
public abstract class CommonBean<T> {

    /**
     *
     */
    @PersistenceContext(unitName = "lzhangMP3PU")
    protected EntityManager em;
    /**
     *
     */
    protected Class<T> entityClass;

    /**
     *
     * @param id
     * @return
     */
    public T find(Long id) {
        return em.find(entityClass, id);
    }

    /**
     *
     * @param s
     * @return
     */
    public List<T> findAll(String s) {
        TypedQuery<T> query = em.createNamedQuery(s, entityClass);
        return query.getResultList();
    }

    /**
     *
     * @param s
     * @return
     */
    public T findByName(String s){
        TypedQuery<T> query = em.createNamedQuery(s, entityClass);
        return query.getSingleResult();
    }
    
    /**
     *
     * @param entity
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     *
     * @param entity
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(entity);
    }
}

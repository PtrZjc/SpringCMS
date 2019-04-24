package pl.zajacp.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public abstract class AbstractDao<T> { //implements IDao<T>

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public void setClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + entityClass.getName()).getResultList();
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long entityId) {
        T entity = findById(entityId);
        delete(entity);
    }
}
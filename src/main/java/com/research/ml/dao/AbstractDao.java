package com.research.ml.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<ID extends Serializable, T> {
    @PersistenceContext
    EntityManager entityManager;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     * Retrieve an <code>T</code> from the database by id.
     *
     * @param id the id to search for
     * @return the <code>T</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    @SuppressWarnings("unchecked")
    public T findById(ID id) throws DataAccessException {
        T entity = entityManager.find(persistentClass, id);
        if (entity == null)
            throw new ObjectRetrievalFailureException(persistentClass, id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + persistentClass.getName()).getResultList();
    }

    /**
     * Create an <code>T</code> to the database.
     *
     * @param entity the <code>T</code> to create
     * @see BaseEntity#isNew
     */
    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update( T entity ){
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(ID id){
        T entity = findById(id);
        delete(entity);
    }

//    protected Criteria createEntityCriteria(){
//        return entityManager.createCriteria(persistentClass);
//    }

}


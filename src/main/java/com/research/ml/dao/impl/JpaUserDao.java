package com.research.ml.dao.impl;

import com.research.ml.dao.AbstractDao;
import com.research.ml.dao.UserDao;
import com.research.ml.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaUserDao extends AbstractDao<Long, User> implements UserDao {

    @Override
    public User findById(long userId) throws DataAccessException {
        return super.findById(userId);
    }

    @Override
    public User findByName(String username) throws DataAccessException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(persistentClass);
        Root<User> root = query.from(persistentClass);
        query.select(root);
        query.where(builder.equal(root.get("name"), username));
        return entityManager.createQuery(query).getSingleResult();
    }
}

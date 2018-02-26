package com.research.ml.dao;

import com.research.ml.model.User;
import org.springframework.dao.DataAccessException;

public interface UserDao {

    /**
     * Retrieve an <code>User</code> from the database by id.
     *
     * @param userId the id to search for
     * @return the <code>User</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    User findById(long userId) throws DataAccessException;

    /**
     * Retrieve an <code>User</code> from the database by name.
     *
     * @param username the name to search for
     * @return the <code>User</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    User findByName(String username) throws DataAccessException;
}

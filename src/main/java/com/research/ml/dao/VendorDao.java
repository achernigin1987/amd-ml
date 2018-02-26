package com.research.ml.dao;

import com.research.ml.model.DeviceType;
import com.research.ml.model.Vendor;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Set;

public interface VendorDao {
    /**
     * Retrieve an <code>Vendor</code> from the database by id.
     *
     * @param id the id to search for
     * @return the <code>Vendor</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Vendor findById(int vendorId) throws DataAccessException;

    List<Vendor> findAll();
    /**
     * Save an <code>Vendor</code> to the database, either inserting or updating it.
     *
     * @param vendor the <code>Vendor</code> to save
     * @see BaseEntity#isNew
     */

    Set<DeviceType> findDeviceTypes(int vendorId) throws DataAccessException;

    void saveVendor(Vendor vendor);

    void deleteById(int vendorId);


    //Employee findEmployeeBySsn(String ssn);
}

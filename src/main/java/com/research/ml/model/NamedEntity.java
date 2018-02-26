package com.research.ml.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Simple JavaBean domain object adds a name property to derived object.
 */
@MappedSuperclass
public class NamedEntity {

    @Column(name = "name")
    protected String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

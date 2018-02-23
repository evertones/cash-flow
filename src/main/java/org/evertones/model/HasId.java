package org.evertones.model;


public interface HasId<T extends Model, ID extends Number> {

    ID getId();
    T setId(ID id);

}

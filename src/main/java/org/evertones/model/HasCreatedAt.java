package org.evertones.model;

import java.time.temporal.Temporal;

public interface HasCreatedAt<T extends Model, D extends Temporal> {

    D getCreatedAt();
    T setCreatedAt(D temporal);

}

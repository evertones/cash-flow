package org.evertones.model;

import java.time.temporal.Temporal;

public interface HasUpdatedAt<T extends Model, D extends Temporal> {

    D getUpdatedAt();
    T setUpdatedAt(D temporal);

}

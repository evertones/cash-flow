package org.evertones.api;

import org.evertones.controller.dto.MessageDto;
import org.evertones.model.Model;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseDto<T extends Model> {

    private HttpStatus status;
    private MessageDto message;
    private T          entity;
    private List<T> entities;

    public HttpStatus getStatus() {
        return status;
    }

    public ResponseDto setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public MessageDto getMessage() {
        return message;
    }

    public ResponseDto setMessage(MessageDto message) {
        this.message = message;
        return this;
    }

    public T getEntity() {
        return entity;
    }

    public ResponseDto setEntity(T entity) {
        this.entity = entity;
        return this;
    }

    public List<T> getEntities() {
        return entities;
    }

    public ResponseDto setEntities(List<T> entities) {
        this.entities = entities;
        return this;
    }

}

package org.evertones.api;

import org.evertones.controller.dto.MessageDto;
import org.evertones.model.Model;
import org.springframework.http.HttpStatus;

public class ResponseDto<T extends Model> {

    private HttpStatus status;
    private MessageDto message;
    private T          entity;

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

}

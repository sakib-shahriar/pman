package com.ssdev.pman.execption;

import com.ssdev.pman.constant.Entity;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Entity entity) {
        super(entity.getName() + " not found");
    }
}

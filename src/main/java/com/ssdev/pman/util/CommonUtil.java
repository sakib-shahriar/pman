package com.ssdev.pman.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommonUtil {
    public List<String> getFieldNamesFromBindingResult(BindingResult result) {
        List<String> fieldNames = new ArrayList<>();
        result.getAllErrors().forEach(e -> {
            FieldError fieldError = (FieldError)e;
            fieldNames.add(fieldError.getField());
        });
        return fieldNames;
    }

    public String buildErrorMessage(List<String> errorFields) {
        StringBuilder message = new StringBuilder();
        for(String field: errorFields) {
            message.append(field).append(", ");
        }
        message.delete(message.length() - 2, message.length() - 1);
        if(errorFields.size() > 1) {
            message.append("fields are not valid");
        }
        else {
            message.append("field is not valid");
        }
        return message.toString();
    }

    public UserDetails getLoggedInUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

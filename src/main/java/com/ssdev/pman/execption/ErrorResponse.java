package com.ssdev.pman.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Date timeStamp;
    private String message;
    private String details;
}

package com.spring.jwtchecking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private int code;

    private String status;

    private String message;

    private Object payLoad;
    public ApiResponse(int value, String message) {
        this.code=value;
        this.message=message;
    }

    public ApiResponse(int code, String message, Object payLoad) {
        this.code = code;
        this.message = message;
        this.payLoad = payLoad;
    }

    public ApiResponse(int value, Object response) {
        this.code=value;
        this.payLoad=response;
    }
}

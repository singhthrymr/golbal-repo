package com.security.config;

import com.security.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLTimeoutException;

@ControllerAdvice
public class GlobalExceptionHandler {


        @ExceptionHandler(Exception.class)
        protected ResponseEntity<GenericResponse> handleExceptions(
                Exception ex,
                WebRequest request
        )
        {
            if(ex instanceof RuntimeException) {
                return composeRunTimeException(ex, request);
            }else if(ex instanceof SQLTimeoutException){
                return composeTimeoutException(ex, request);
            }else{
                return composeGenericException(ex, request);
            }
        }

        private  ResponseEntity<GenericResponse> composeTimeoutException( Exception ex,
                                                                                 WebRequest request){
            //Write if any logic required for a specific  Exception type as per business logic
            return new ResponseEntity<GenericResponse>(composeAppResponseDTO(ex.getMessage(), HttpStatus.GATEWAY_TIMEOUT.value(), request.getDescription(true)), HttpStatus.GATEWAY_TIMEOUT);
        }

        private  ResponseEntity<GenericResponse> composeRunTimeException( Exception ex,
                                                                                 WebRequest request){
            //Write if any logic required for a specific  Exception type as per business logic
            return new ResponseEntity<GenericResponse>(composeAppResponseDTO(ex.getMessage(),HttpStatus.BAD_REQUEST.value(), request.getDescription(true)), HttpStatus.BAD_REQUEST);
        }

        private  ResponseEntity<GenericResponse> composeGenericException( Exception ex,
                                                                                 WebRequest request){
            //Write if any logic required for a specific  Exception type as per business logic
            return new ResponseEntity<GenericResponse>(composeAppResponseDTO(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.value(), request.getDescription(true)), HttpStatus.NOT_ACCEPTABLE);
        }
        private GenericResponse composeAppResponseDTO(String message, int errorCode,String status ){
            return new GenericResponse(errorCode, message, status);
        }

}

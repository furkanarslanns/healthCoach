package com.example.Handler;

import com.example.excaption.BaseExcaption;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExcaptionHandler {


    @ExceptionHandler(BaseExcaption.class)
    public ResponseEntity<ApiError> handleBaseExcaption(BaseExcaption baseExcaption, WebRequest request){

        return ResponseEntity.badRequest().body(createApiError(baseExcaption.getMessage(),request));

    }

    public <E> ApiError<E>  createApiError(E message, WebRequest request){
         ApiError<E> apiError = new ApiError<E>();
         apiError.setStatus(HttpStatus.BAD_REQUEST.value());

         Excaption<E> excaption = new Excaption<E>();
         excaption.setMessage(message);
         excaption.setCreateTime(new Date());
         excaption.setHostName(getHostName());
         excaption.setPath(request.getDescription(false));
apiError.setExcaption(excaption);
return apiError;
    }

    public String getHostName() {

        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }




}

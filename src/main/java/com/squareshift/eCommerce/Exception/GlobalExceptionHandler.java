//package com.squareshift.eCommerce.Exception;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(FeignException.class)
//    public String handleFeignStatusException(FeignException e, HttpServletResponse response) throws JSONException {
//        response.setStatus(e.status());
//        return new JSONObject(e.contentUTF8()).toString(1);
//    }
//
//}
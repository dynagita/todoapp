package com.example.todoapp.api.controllers.handlers;

import com.example.todoapp.utils.constants.ErrorResponseCodes;
import com.example.todoapp.application.responses.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Class for handle response and support responses
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    private final View error;

    public ResponseHandler(View error) {
        this.error = error;
    }

    /**
     * Check if the response was correct
     * @param returnType the return type
     * @param converterType the selected converter type
     * @return Boolean
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ResponseEntity.class.isAssignableFrom(returnType.getParameterType());
    }

    /**
     * Handle response and make response correct for NOT_FOUND and BUSINESS_VALIDATION Response object
     * @param body the body to be written
     * @param returnType the return type of the controller method
     * @param selectedContentType the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request the current request
     * @param response the current response
     * @return ResponseEntity
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        var data = (Response) body;
        var errorCode = data.getError().getCode();
        if (errorCode.equals(ErrorResponseCodes.NOT_FOUND)) {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        }
        else if (errorCode.equals(ErrorResponseCodes.BUSINESS_VALIDATION)) {
            response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return body;
    }
}

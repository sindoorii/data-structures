package com.tekact.platform.admin.exception;

import com.tekact.platform.common.exception.TException;
import com.tekact.platform.common.exception.THttpExceptionMap;
import com.tekact.platform.common.response.TConstraintViolationError;
import com.tekact.platform.common.response.TError;
import com.tekact.platform.common.response.TSubError;
import com.tekact.platform.common.response.TValidationError;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@EnableAspectJAutoProxy
public class TExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<TSubError> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            TValidationError validationError = new TValidationError(error.getObjectName(), error.getField(), error.getRejectedValue(), error.getDefaultMessage());
            errors.add(validationError);
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            TValidationError validationError = new TValidationError(error.getObjectName(), error.getDefaultMessage());
            errors.add(validationError);
        }
        TError error = new TError(HttpStatus.BAD_REQUEST, ex.getMessage());
        error.setErrors(errors);
        return handleExceptionInternal(ex, error, headers, error.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Invalid request format";
        return buildResponseEntity(new TError(HttpStatus.BAD_REQUEST, error, ex.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        TError error = new TError(NOT_FOUND);
        error.setMessage(ex.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<TSubError> errors = new ArrayList();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            TConstraintViolationError constraintViolationError = new TConstraintViolationError(violation.getRootBeanClass().getName()
                    , violation.getPropertyPath(), violation.getMessage());
            errors.add(constraintViolationError);
        }
        TError error = new TError(HttpStatus.CONFLICT, ex.getMessage());
        error.setErrors(errors);
        return new ResponseEntity<Object>(
                error, new HttpHeaders(), error.getStatus());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handlePersistenceException(final DataIntegrityViolationException ex) {

        Throwable cause = ex.getRootCause();
        List<TSubError> errors = new ArrayList();

        if (cause instanceof SQLIntegrityConstraintViolationException) {

            SQLIntegrityConstraintViolationException consEx = (SQLIntegrityConstraintViolationException) cause;
            TError error = new TError(HttpStatus.CONFLICT, ex.getMessage());
            error.setErrors(errors);
            return new ResponseEntity<Object>(
                    error, new HttpHeaders(), error.getStatus());
        }

        TError error = new TError(HttpStatus.CONFLICT, ex.getMessage());
        error.setErrors(errors);
        return new ResponseEntity<Object>(
                error, new HttpHeaders(), error.getStatus());
    }

    @ExceptionHandler({TException.class})
    public ResponseEntity<Object> handleCheckedException(TException ex, WebRequest request) {
        TError error = new TError(THttpExceptionMap.getStatus(ex.getType()), ex.getCode(), ex.getMessage());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(
                error, new HttpHeaders(), error.getStatus());
    }

    /*
        Fall back handler
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        TError error = new TError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<Object>(
                error, new HttpHeaders(), error.getStatus());
    }

    private ResponseEntity<Object> buildResponseEntity(TError error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

}

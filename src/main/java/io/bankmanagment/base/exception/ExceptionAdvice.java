package io.bankmanagment.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionInfo.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build()
                );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionInfo> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionInfo.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

    @ExceptionHandler(CustomMethodNotAllowedException.class)
    public ResponseEntity<ExceptionInfo> handleNotFoundException(CustomMethodNotAllowedException exception) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(ExceptionInfo.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                        .build()
                );
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    ResponseEntity<Object> handleConstraintViolationException( ConstraintViolationException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionInfo.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ResponseEntity<Object> handleMethodArgumentNotValidException( MethodArgumentNotValidException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionInfo.builder()
                        .message(ex.getAllErrors().get(0).getDefaultMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<ExceptionInfo> handleGeneralException(@NonNull Throwable ex) {
        if (ex.getCause() != null && ex.getCause().getClass() == NotFoundException.class) {
            return handleNotFoundException((NotFoundException) ex.getCause());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionInfo.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }
}

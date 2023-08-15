package io.bankmanagment.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
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

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<ExceptionInfo> handleGeneralException(@NonNull Throwable ex) {
        if (ex.getCause().getClass() == NotFoundException.class) {
            return handleNotFoundException((NotFoundException) ex.getCause());
        }


        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionInfo.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build()
                );
    }
}

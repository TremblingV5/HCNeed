package org.hcneed.server.common.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.hcneed.server.common.response.R;
import org.hcneed.server.constants.ApiCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleArg(MethodArgumentNotValidException exception) {
        String uuid = java.util.UUID.randomUUID().toString();
        int code = ApiCode.PARAMS_ILLEGAL;

        FieldError error = exception.getBindingResult().getFieldError();

        if(error.getDefaultMessage().contains("不能为空")) {
            code = ApiCode.PARAMS_NULL;
        }

        R r = new R();
        r.setCode(code);
        r.setMessage(error.getField()+":"+error.getDefaultMessage());

        log.error("[" + uuid + "]", exception);
        return r;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public R handleConstraint(ConstraintViolationException exception) {
        String uuid = java.util.UUID.randomUUID().toString();
        int code = ApiCode.PARAMS_ILLEGAL;

        if(exception.getMessage().contains("不能为空")) {
            code = ApiCode.PARAMS_NULL;
        }

        R r = new R();
        r.setCode(code);
        r.setMessage(exception.getMessage());

        log.error("[" + uuid + "]", exception);
        return r;
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public R handleValid(ValidationException exception) {
        String uuid = java.util.UUID.randomUUID().toString();
        int code = ApiCode.PARAMS_ILLEGAL;

        if(exception.getMessage().contains("不能为空")) {
            code = ApiCode.PARAMS_NULL;
        }

        R r = new R();
        r.setCode(code);
        r.setMessage(exception.getMessage());

        log.error("[" + uuid + "]", exception);
        return r;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public R handleBaseException(BaseException baseException) {
        String uuid = java.util.UUID.randomUUID().toString();

        R r=new R();
        r.setCode(baseException.code);
        r.setMessage(baseException.msg);

        log.error("[" + uuid + "]", baseException);
        return r;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R handleEx(Exception exception) {
        String uuid = java.util.UUID.randomUUID().toString();

        R r = new R();
        r.setCode(ApiCode.INTERNAL_SERVER_ERROR);
        r.setMessage(ApiCode.getMessage(ApiCode.INTERNAL_SERVER_ERROR) + uuid);

        log.error("[" + uuid + "]", exception);
        return r;
    }
}


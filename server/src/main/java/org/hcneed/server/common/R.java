package org.hcneed.server.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T type;
    private int code;
    private String message;
    private Object data;
    private Long count;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnDateTime;

    public R() {}

    public R code(int code) {
        this.code = code;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }

    public R count(Long count) {
        this.count = count;
        return this;
    }

    public static R ok() {
        R r = new R();
        r.setCode(0);
        r.setMessage("success");
        return r;
    }

    public static R error(int code) {
        R r = new R();
        r.setCode(code);
        r.setMessage("defeat");
        return r;
    }

    public R response() {
        this.returnDateTime = LocalDateTime.now();
        return this;
    }
}

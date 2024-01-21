package org.hcneed.server.common.exception;

import lombok.Getter;

@Getter
public class BaseException extends Throwable {
    private static final long serialVersionUID = 1L;

    public int code = 0;
    public String msg = "success";
}

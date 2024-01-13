package org.hcneed.server.common.exception;

import lombok.Getter;

@Getter
public class BaseException {
    private static final long serialVersionUID = 1L;

    public int code = 0;
    public String msg = "success";
}

package org.hcneed.server.exceptions.user;

import org.hcneed.server.common.exception.BaseException;

public class PasswordError extends BaseException {
    private static final long serialVersionUID = 1L;

    public PasswordError() {
        this.code = 1103;
        this.msg = "Password error";
    }
}

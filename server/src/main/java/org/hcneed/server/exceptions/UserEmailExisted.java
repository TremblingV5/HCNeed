package org.hcneed.server.exceptions;

import org.hcneed.server.common.exception.BaseException;

public class UserEmailExisted extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserEmailExisted() {
        this.code = 1101;
        this.msg = "User email existed";
    }
}

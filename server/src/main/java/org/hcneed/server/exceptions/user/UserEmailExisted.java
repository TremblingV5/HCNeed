package org.hcneed.server.exceptions.user;

import org.hcneed.server.common.exception.BaseException;

public class UserEmailExisted extends BaseException {
    public UserEmailExisted() {
        this.code = 1101;
        this.msg = "User email existed";
    }
}

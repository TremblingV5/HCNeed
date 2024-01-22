package org.hcneed.server.exceptions.user;

import org.hcneed.server.common.exception.BaseException;

public class UserNotExists extends BaseException {

    public UserNotExists() {
        this.code = 1102;
        this.msg = "User not exist";
    }
}

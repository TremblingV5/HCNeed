package org.hcneed.server.exceptions.user;

import org.hcneed.server.common.exception.BaseException;

public class UserHasBeenBanned extends BaseException {
    public UserHasBeenBanned() {
        this.code = 1005;
        this.msg = "User has been banned";
    }
}

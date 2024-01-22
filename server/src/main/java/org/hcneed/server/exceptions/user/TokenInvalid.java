package org.hcneed.server.exceptions.user;

import org.hcneed.server.common.exception.BaseException;

public class TokenInvalid extends BaseException {
    public TokenInvalid() {
        this.code = 1104;
        this.msg = "Token invalid";
    }
}

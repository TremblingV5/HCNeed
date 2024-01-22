package org.hcneed.server.services;

import org.hcneed.server.common.exception.BaseException;
import org.hcneed.server.entities.models.User;

public interface UserService {
    User login(String email, String password);
    User register(String email, String validateCode, String password);
    User load(Long id);
}

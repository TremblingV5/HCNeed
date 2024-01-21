package org.hcneed.server.services;

import org.hcneed.server.entities.models.User;
import org.hcneed.server.exceptions.UserEmailExisted;

public interface UserService {
    User login(String username, String password);
    User register(String email, String validateCode, String password) throws UserEmailExisted;
}

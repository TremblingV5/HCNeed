package org.hcneed.server.services;

import org.hcneed.server.common.exception.BaseException;
import org.hcneed.server.entities.models.User;

import java.util.ArrayList;
import java.util.List;


public interface UserService {
    User login(String email, String password);
    User register(String email, String validateCode, String password);
    User load(Long id);

    void ban(Long id);
    List<User> list();
}

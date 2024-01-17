package org.hcneed.server.services;

import org.hcneed.server.entities.models.User;

public interface UserService {
    User login(String username, String password);
    User register(String username, String password);
}

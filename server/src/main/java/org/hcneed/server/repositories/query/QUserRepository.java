package org.hcneed.server.repositories.query;

import org.hcneed.server.entities.models.User;

public interface QUserRepository {
    public boolean isEmailExists(String email);
    public User saveNewUser(String email, String password);
}

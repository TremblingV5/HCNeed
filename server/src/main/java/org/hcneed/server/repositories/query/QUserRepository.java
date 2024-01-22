package org.hcneed.server.repositories.query;

import org.hcneed.server.entities.models.User;

public interface QUserRepository {
    boolean isEmailExists(String email);
    void banUser(Long id);
}

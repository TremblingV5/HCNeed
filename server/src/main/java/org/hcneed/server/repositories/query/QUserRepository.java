package org.hcneed.server.repositories.query;

public interface QUserRepository {
    boolean isEmailExists(String email);
    void banUser(Long id);
}

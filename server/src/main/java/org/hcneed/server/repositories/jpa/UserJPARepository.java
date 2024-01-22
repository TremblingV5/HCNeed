package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends BaseRepository<User, Long> {
    User findByEmail(String email);
    User findUserById(Long id);
}

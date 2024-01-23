package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.relations.UserFollowPosition;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowPositionJPARepository extends BaseRepository<UserFollowPosition, Long> {
    UserFollowPosition save(UserFollowPosition userFollowPosition);
}

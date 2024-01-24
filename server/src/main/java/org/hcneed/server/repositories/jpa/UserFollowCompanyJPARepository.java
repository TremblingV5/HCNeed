package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.relations.UserFollowCompany;
import org.hcneed.server.entities.models.relations.UserFollowPosition;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowCompanyJPARepository extends BaseRepository<UserFollowCompany, Long> {
    UserFollowCompany save(UserFollowCompany userFollowCompany);
}

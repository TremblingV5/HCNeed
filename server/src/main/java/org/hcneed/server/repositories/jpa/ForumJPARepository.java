package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.Forum;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumJPARepository extends BaseRepository<Forum, Long> {
    List<Forum> findAll();
    Forum save(Forum forum);
    Forum getForumById(Long id);
}

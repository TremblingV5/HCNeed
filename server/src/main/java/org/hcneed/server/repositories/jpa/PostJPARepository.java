package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJPARepository extends BaseRepository<Post, Long> {
    Post save(Post post);
    Post getPostById(Long id);
    void deleteById(Long id);
}

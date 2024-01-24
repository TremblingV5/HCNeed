package org.hcneed.server.repositories.query;

import org.hcneed.server.entities.models.Post;
import org.springframework.stereotype.Repository;

public interface QPostRepository {
    Post updateById(Long id, Post post);
}

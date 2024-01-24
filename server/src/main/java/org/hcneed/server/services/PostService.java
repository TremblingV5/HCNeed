package org.hcneed.server.services;

import org.hcneed.server.entities.models.Post;

public interface PostService {
    Post post(Post post);
    Post load(Long id);
    Post update(Long id, Post post);
    void delete(Long id);
}

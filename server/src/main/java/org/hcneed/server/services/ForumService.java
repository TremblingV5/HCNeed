package org.hcneed.server.services;

import org.hcneed.server.entities.models.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> list();
    Forum load(Long id);
    Forum create(Forum forum);
    Forum addTag(Long id, Long tagId);
}

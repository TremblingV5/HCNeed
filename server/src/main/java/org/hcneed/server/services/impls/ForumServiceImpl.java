package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.Forum;
import org.hcneed.server.repositories.jpa.ForumJPARepository;
import org.hcneed.server.services.ForumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Resource
    private ForumJPARepository forumJPARepository;

    @Override
    public List<Forum> list() {
        return forumJPARepository.findAll();
    }

    @Override
    public Forum load(Long id) {
        return forumJPARepository.getForumById(id);
    }

    @Override
    public Forum create(Forum forum) {
        return forumJPARepository.save(forum);
    }

    @Override
    public Forum addTag(Long id, Long tagId) {
        return null;
    }
}

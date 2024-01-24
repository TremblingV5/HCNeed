package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.hcneed.server.entities.models.Post;
import org.hcneed.server.repositories.jpa.PostJPARepository;
import org.hcneed.server.repositories.query.QPostRepository;
import org.hcneed.server.repositories.query.impl.QPostRepositoryImpl;
import org.hcneed.server.services.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostJPARepository postJPARepository;

    @Resource
    private QPostRepositoryImpl qPostRepositoryImpl;

    @Override
    public Post post(Post post) {
        return postJPARepository.save(post);
    }

    @Override
    public Post load(Long id) {
        return postJPARepository.getPostById(id);
    }

    @Override
    @Transactional
    public Post update(Long id, Post post) {
         qPostRepositoryImpl.updateById(id, post);
         return postJPARepository.getPostById(id);
    }

    @Override
    public void delete(Long id) {
        postJPARepository.deleteById(id);
    }
}

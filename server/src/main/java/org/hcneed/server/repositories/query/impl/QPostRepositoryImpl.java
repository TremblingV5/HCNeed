package org.hcneed.server.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.Post;
import org.hcneed.server.entities.models.QPost;
import org.hcneed.server.repositories.query.QPostRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QPostRepositoryImpl implements QPostRepository {

    @Resource
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Post updateById(Long id, Post post) {
        jpaQueryFactory.update(QPost.post)
            .where(QPost.post.id.eq(id))
            .set(QPost.post.title, post.getTitle())
            .set(QPost.post.content, post.getContent())
            .execute();
        return null;
    }
}

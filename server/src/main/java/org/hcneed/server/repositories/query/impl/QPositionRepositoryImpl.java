package org.hcneed.server.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.QPosition;
import org.hcneed.server.repositories.query.QPositionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QPositionRepositoryImpl implements QPositionRepository {

    @Resource
    private JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public void deleteById(Long id) {
        jpaQueryFactory.delete(QPosition.position).where(QPosition.position.id.eq(id)).execute();
    }
}

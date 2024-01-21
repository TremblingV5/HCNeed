package org.hcneed.server.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.QUser;
import org.hcneed.server.entities.models.User;
import org.hcneed.server.repositories.query.QUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QUserRepositoryImpl implements QUserRepository {
    @Resource
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean isEmailExists(String email) {
        Long cnt = jpaQueryFactory
                    .select(QUser.user.count())
                    .from(QUser.user)
                    .where(QUser.user.email.eq(email))
                    .fetchOne();
        return cnt > 0;
    }

    @Override
    public User saveNewUser(String email, String password) {
        return null;
    }
}

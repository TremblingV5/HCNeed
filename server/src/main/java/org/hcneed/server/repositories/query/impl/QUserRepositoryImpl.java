package org.hcneed.server.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.QUser;
import org.hcneed.server.entities.models.User;
import org.hcneed.server.exceptions.user.UserNotExists;
import org.hcneed.server.repositories.query.QUserRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

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
    public void banUser(Long id) {
        User user = jpaQueryFactory.select(QUser.user).where(QUser.user.id.eq(id)).fetchOne();
        if (user == null) {
            throw new UserNotExists();
        }
        jpaQueryFactory
                .update(QUser.user)
                .set(QUser.user.banned_at, new Timestamp(System.currentTimeMillis()))
                .where(QUser.user.id.eq(id))
                .execute();
    };
}

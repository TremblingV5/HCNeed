package org.hcneed.server.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.QCompany;
import org.hcneed.server.repositories.query.QCompanyRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QCompanyRepositoryImpl implements QCompanyRepository {
    @Resource
    private JPAQueryFactory jpaQueryFactory;


    @Override
    @Transactional
    public void deleteById(Long id) {
        jpaQueryFactory.delete(QCompany.company).where(QCompany.company.id.eq(id)).execute();
    }
}

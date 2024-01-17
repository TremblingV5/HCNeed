package org.hcneed.server.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAFactory {
    @Bean
    public JPAQueryFactory jpaQueryFactory(jakarta.persistence.EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}

package org.hcneed.server.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.hcneed.server.repositories.jpa")
@EntityScan(basePackages = "org.hcneed.server.entities.models")
public class RepositoryConfiguration {
}

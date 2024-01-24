package org.hcneed.server.services;

import org.hcneed.server.entities.models.Company;
import org.hcneed.server.entities.models.relations.UserFollowCompany;

import java.util.List;

public interface CompanyService {
    List<Company> list();
    Company load(Long id);
    Company update(Company company);
    void delete(Long id);
    UserFollowCompany follow(Long id, Long userId);
}

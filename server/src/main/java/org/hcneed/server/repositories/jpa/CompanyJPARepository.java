package org.hcneed.server.repositories.jpa;


import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyJPARepository extends BaseRepository<Company, Long> {
    List<Company> findAll();
    Company getCompanyById(Long id);
    Company getCompanyByName(String name);
    boolean existsById(Long id);
}

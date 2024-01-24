package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.Company;
import org.hcneed.server.entities.models.relations.UserFollowCompany;
import org.hcneed.server.exceptions.company.CompanyNotExists;
import org.hcneed.server.repositories.jpa.CompanyJPARepository;
import org.hcneed.server.repositories.jpa.UserFollowCompanyJPARepository;
import org.hcneed.server.repositories.jpa.UserFollowPositionJPARepository;
import org.hcneed.server.repositories.query.impl.QCompanyRepositoryImpl;
import org.hcneed.server.services.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private QCompanyRepositoryImpl qCompanyRepository;
    @Resource
    private CompanyJPARepository companyJPARepository;
    @Resource
    private UserFollowCompanyJPARepository userFollowCompanyJPARepository;

    @Override
    public List<Company> list() {
        return companyJPARepository.findAll();
    }

    @Override
    public Company load(Long id) {
        return companyJPARepository.getCompanyById(id);
    }

    @Override
    public Company update(Company company) {
        return null;
    }

    @Override
    public void delete(Long id) {
        qCompanyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserFollowCompany follow(Long id, Long userId) {
        boolean exists = companyJPARepository.existsById(id);
        if (!exists) {
            throw new CompanyNotExists();
        }

        UserFollowCompany userFollowCompany = new UserFollowCompany();
        userFollowCompany.setCompanyId(id);
        userFollowCompany.setUserId(userId);
        userFollowCompany.setFollow(true);
        return userFollowCompanyJPARepository.save(userFollowCompany);
    }
}

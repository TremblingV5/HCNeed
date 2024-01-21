package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.User;
import org.hcneed.server.exceptions.UserEmailExisted;
import org.hcneed.server.repositories.jpa.UserJPARepository;
import org.hcneed.server.repositories.query.impl.QUserRepositoryImpl;
import org.hcneed.server.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private QUserRepositoryImpl qUserRepositoryImpl;

    @Resource
    private UserJPARepository userJPARepository;

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    @Transactional
    public User register(String email, String validateCode, String password) {
        boolean exists = qUserRepositoryImpl.isEmailExists(email);
        if (exists) {
            return null;
        }

        User user = new User();
        user.setEmail(email);
        user.setEncrypted(password);
        user = userJPARepository.save(user);
        return user;
    }
}

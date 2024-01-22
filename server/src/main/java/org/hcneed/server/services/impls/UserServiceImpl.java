package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.User;
import org.hcneed.server.exceptions.user.UserEmailExisted;
import org.hcneed.server.exceptions.user.UserNotExists;
import org.hcneed.server.repositories.jpa.UserJPARepository;
import org.hcneed.server.repositories.query.impl.QUserRepositoryImpl;
import org.hcneed.server.services.UserService;
import org.hcneed.server.utils.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private QUserRepositoryImpl qUserRepositoryImpl;

    @Resource
    private UserJPARepository userJPARepository;

    @Override
    public User login(String email, String password) {
        User user = userJPARepository.findByEmail(email);
        return user;
    }

    @Override
    @Transactional
    public User register(String email, String validateCode, String password) {
        boolean exists = qUserRepositoryImpl.isEmailExists(email);
        if (exists) {
            throw new UserEmailExisted();
        }

        String salt = PasswordUtil.generateSalt();
        String encrypted = PasswordUtil.encrypt(password, salt);

        User user = new User();
        user.setEmail(email);
        user.setEncrypted(encrypted);
        user.setSalt(salt);
        user = userJPARepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User load(Long id) {
        User user = userJPARepository.findUserById(id);
        if (user == null) {
            throw new UserNotExists();
        }
        return user;
    }
}

package org.hcneed.server.services.impls;

import jakarta.annotation.Resource;
import org.hcneed.server.entities.models.Position;
import org.hcneed.server.entities.models.relations.UserFollowPosition;
import org.hcneed.server.exceptions.position.PositionNotExists;
import org.hcneed.server.repositories.jpa.PositionJPARepository;
import org.hcneed.server.repositories.jpa.UserFollowPositionJPARepository;
import org.hcneed.server.repositories.query.impl.QPositionRepositoryImpl;
import org.hcneed.server.services.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private QPositionRepositoryImpl qPositionRepository;
    @Resource
    private PositionJPARepository positionJPARepository;
    @Resource
    private UserFollowPositionJPARepository userFollowPositionJPARepository;

    @Override
    public List<Position> list() {
        return positionJPARepository.findAll();
    }

    @Override
    public Position load(Long id) {
        return positionJPARepository.getPositionById(id);
    }

    @Override
    public Position update(Position position) {
        return null;
    }

    @Override
    public void delete(Long id) {
        qPositionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserFollowPosition follow(Long id, Long userId) {
        boolean exists = positionJPARepository.existsById(id);
        if (!exists) {
            throw new PositionNotExists();
        }

        UserFollowPosition userFollowPosition = new UserFollowPosition();
        userFollowPosition.setPositionId(id);
        userFollowPosition.setUserId(userId);
        userFollowPosition.setFollow(true);
        return userFollowPositionJPARepository.save(userFollowPosition);
    }
}

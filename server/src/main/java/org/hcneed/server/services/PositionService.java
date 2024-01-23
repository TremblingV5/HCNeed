package org.hcneed.server.services;

import org.hcneed.server.entities.models.Position;
import org.hcneed.server.entities.models.relations.UserFollowPosition;

import java.util.List;

public interface PositionService {
    List<Position> list();
    Position load(Long id);
    Position update(Position position);
    void delete(Long id);
    UserFollowPosition follow(Long id, Long userId);
}

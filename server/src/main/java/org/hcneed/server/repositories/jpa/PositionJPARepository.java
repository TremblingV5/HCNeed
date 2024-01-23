package org.hcneed.server.repositories.jpa;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.entities.models.Position;
import org.hcneed.server.entities.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionJPARepository extends BaseRepository<Position, Long> {
    List<Position>  findAll();
    Position getPositionById(Long id);
    boolean existsById(Long id);
}

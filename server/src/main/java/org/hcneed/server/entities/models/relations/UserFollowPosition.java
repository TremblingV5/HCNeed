package org.hcneed.server.entities.models.relations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "UserFollowPosition")
public class UserFollowPosition extends BaseModel {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long positionId;

    @Column(nullable = false)
    private boolean isFollow;

}

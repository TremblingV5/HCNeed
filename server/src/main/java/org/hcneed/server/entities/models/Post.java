package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "Post")
public class Post extends BaseModel {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Long forumId;

    @Column(nullable = false, updatable = false)
    private Long createdBy;

}

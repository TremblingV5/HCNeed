package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "CrawlTask")
public class CrawlTask extends BaseModel {

    @Column(nullable = false)
    private String templateId;

    @Column(nullable = false)
    private String status;

}

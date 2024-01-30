package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "CrawlerTemplate")
public class CrawlerTemplate extends BaseModel {

    @Column
    private Long companyId;

    @Column(nullable = false)
    private String crawlerName;

}

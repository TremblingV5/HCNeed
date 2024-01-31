package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "Position", uniqueConstraints = @UniqueConstraint(columnNames = {"uuid", "company_id"}))
public class Position extends BaseModel {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Long companyId;

    @Column
    private String location;

    @Column
    private String jobCategory;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private String Uuid;

}

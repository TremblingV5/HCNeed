package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;

@Data
@Entity
@Table(name = "Company")
public class Company extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

}

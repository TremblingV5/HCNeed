package org.hcneed.server.common.model;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.sql.Timestamp;

@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(generator = "SnowflakeUtil", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "SnowflakeUtil", strategy = "org.hcneed.server.utils.SnowflakeUtil")
    private Long id;

    @Column(name = "created_at", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
    @Generated(GenerationTime.INSERT)
    private Timestamp created_at;

    @Column(name = "updated_at", columnDefinition = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Timestamp updated_at;

    public BaseModel () {}

    public Long getId() {
        return this.id;
    }

    public void preInsert() {}

    public void preUpdate() {}
}

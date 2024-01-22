package org.hcneed.server.entities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;
import org.hcneed.server.enums.UserType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "User")
public class User extends BaseModel {

    @Column(nullable = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true, length = 13)
    private String mobile;

    @Column(nullable = true)
    @JsonIgnore
    private String salt;

    @Column(nullable = false)
    @JsonIgnore
    private String encrypted;

    @Column(nullable = true)
    private Enum<UserType> type;

    @Column(name = "banned_at")
    private Timestamp banned_at;

}

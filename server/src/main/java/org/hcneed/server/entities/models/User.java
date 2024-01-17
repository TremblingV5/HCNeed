package org.hcneed.server.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hcneed.server.common.model.BaseModel;
import org.hcneed.server.enums.UserType;

@Data
@Entity
@Table(name = "User")
public class User extends BaseModel {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 13)
    private String mobile;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private String encrypted;

    @Column(nullable = false)
    private Enum<UserType> type;

}

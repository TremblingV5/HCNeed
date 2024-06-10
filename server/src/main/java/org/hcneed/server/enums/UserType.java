package org.hcneed.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    Normal("普通用户", 1),
    Admin("管理员", 2),
    Super("超级管理员", 3);

    private String type;
    private int index;
}

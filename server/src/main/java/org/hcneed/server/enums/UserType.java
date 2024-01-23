package org.hcneed.server.enums;

import lombok.Data;

public enum UserType {
    Normal("普通用户", 1), Admin("管理员", 2), Super("超级管理员", 3);

    private String type;
    private int index;

    private UserType(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

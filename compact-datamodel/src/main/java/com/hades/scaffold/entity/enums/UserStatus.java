package com.hades.scaffold.entity.enums;

/**
 * <p>User: XieLei
 * <p>Date: 2016年10月19日 下午2:26:35
 * <p>Version: 1.0
 */
public enum UserStatus {

    normal("正常状态"), blocked("封禁状态");

    private final String info;

    private UserStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

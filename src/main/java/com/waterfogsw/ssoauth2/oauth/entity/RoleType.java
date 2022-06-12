package com.waterfogsw.ssoauth2.oauth.entity;

import java.util.Arrays;

public enum RoleType {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    GUEST("GUEST");

    private final String code;

    RoleType(String code) {
        this.code = code;
    }

    public static RoleType of(String code) {
        return Arrays.stream(RoleType.values())
                .filter(r -> r.getCode().equals(code))
                .findAny()
                .orElse(GUEST);
    }

    public String getCode() {
        return code;
    }
}

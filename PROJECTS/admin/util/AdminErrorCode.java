package com.tekact.platform.admin.util;

import lombok.Getter;

import javax.management.loading.MLetContent;

@Getter
public enum AdminErrorCode {

    ORGANIZATION_NOT_FOUND("M-100", "Organization not found", AdminStatusType.ENTITY_NOT_FOUND),
    APP_NOT_FOUND("M-101", "App not found", AdminStatusType.ENTITY_NOT_FOUND);

    private final String code;
    private final String message;
    private final AdminStatusType type;

    AdminErrorCode(String code, String message, AdminStatusType type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }
}

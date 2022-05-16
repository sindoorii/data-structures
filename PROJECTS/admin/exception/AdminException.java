package com.tekact.platform.admin.exception;

import com.tekact.platform.common.exception.TException;

public class AdminException extends TException {
    public AdminException(String code, String message, Enum type) {
        super(code, message, type);
    }
}

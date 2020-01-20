package com.framework.security.integral.web.util;

/**
 * Send Email Exception
 *
 * @author biezhi
 * @date 2018/10/9
 */
public class SendMailException extends Exception {

    public SendMailException() {
    }

    public SendMailException(String message) {
        super(message);
    }

    public SendMailException(Throwable cause) {
        super(cause);
    }
}

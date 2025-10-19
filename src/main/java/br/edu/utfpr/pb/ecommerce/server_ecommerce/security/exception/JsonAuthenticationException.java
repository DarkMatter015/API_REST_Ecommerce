package br.edu.utfpr.pb.ecommerce.server_ecommerce.security.exception;

import org.springframework.security.core.AuthenticationException;

public class JsonAuthenticationException extends AuthenticationException {
    public JsonAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JsonAuthenticationException(String msg) {
        super(msg);
    }
}

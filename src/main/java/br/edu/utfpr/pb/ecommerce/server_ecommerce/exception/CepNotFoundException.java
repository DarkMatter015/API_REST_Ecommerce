package br.edu.utfpr.pb.ecommerce.server_ecommerce.exception;

public class CepNotFoundException extends RuntimeException {
    public CepNotFoundException(String message) {
        super(message);
    }
}

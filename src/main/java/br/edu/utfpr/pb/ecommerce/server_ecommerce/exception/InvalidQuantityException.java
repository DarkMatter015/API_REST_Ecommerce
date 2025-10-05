package br.edu.utfpr.pb.ecommerce.server_ecommerce.exception;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

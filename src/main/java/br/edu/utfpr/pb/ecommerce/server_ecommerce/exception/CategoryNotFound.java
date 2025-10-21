package br.edu.utfpr.pb.ecommerce.server_ecommerce.exception;

public class CategoryNotFound extends RuntimeException {
    public CategoryNotFound(String message) {
        super(message);
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.exception;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(String message) {
        super(message);
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.util;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.InvalidQuantityException;

public final class ValidationUtils {
    private ValidationUtils() {}

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be a positive number.");
        }
    }

    public static boolean validateStringNullOrBlank(String fieldName) {
        return (fieldName != null && !fieldName.isBlank());
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.util;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidPriceException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidQuantityException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidStringException;

import java.math.BigDecimal;

public final class ValidationUtils {
    private ValidationUtils() {}

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be a positive number.");
        }
    }

    public static void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException("Price must be a positive number.");
        }
    }

    public static void validateStringNullOrBlank(String fieldName) {
        if (fieldName == null || fieldName.isBlank()){
            throw new InvalidStringException("String cannot be null or blank.");
        }
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.util;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidPriceException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidQuantityException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.util.InvalidStringException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;

import java.math.BigDecimal;

public final class ValidationUtils {
    private ValidationUtils() {}

    public static void validateQuantityOfProducts(Integer quantity, Product product) {
        if (quantity == null || quantity > product.getQuantityAvailableInStock()) {
            throw new InvalidQuantityException("Quantity greater than that available in the product stock.");
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

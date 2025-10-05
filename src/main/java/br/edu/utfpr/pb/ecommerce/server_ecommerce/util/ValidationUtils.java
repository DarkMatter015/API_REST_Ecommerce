package br.edu.utfpr.pb.ecommerce.server_ecommerce.util;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.InvalidQuantityException;
import org.modelmapper.ModelMapper;

public final class ValidationUtils {
    private ValidationUtils() {}

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be a positive number.");
        }
    }

    public static <T, D> D convertToDTOGeneric(T entity, Class<D> dtoClass, ModelMapper modelMapper) {
        return modelMapper.map(entity, dtoClass);
    }
}

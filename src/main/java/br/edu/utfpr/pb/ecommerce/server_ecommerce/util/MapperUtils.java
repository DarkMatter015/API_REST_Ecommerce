package br.edu.utfpr.pb.ecommerce.server_ecommerce.util;

import org.modelmapper.ModelMapper;

public class MapperUtils {
    private MapperUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Mapeia um objeto de origem para uma nova instância da classe de destino.
     *
     * @param source O objeto de origem a ser mapeado.
     * @param targetClass A classe (Class<T>) do objeto de destino.
     * @param modelMapper A instância do ModelMapper a ser usada.
     * @param <S> O tipo do objeto de origem.
     * @param <T> O tipo do objeto de destino.
     * @return Uma nova instância de targetClass com os dados mapeados, ou null se a origem for nula.
     */
    public static <S, T> T map(S source, Class<T> targetClass, ModelMapper modelMapper) {
        if (source == null) {
            return null;
        }
        return modelMapper.map(source, targetClass);
    }
}

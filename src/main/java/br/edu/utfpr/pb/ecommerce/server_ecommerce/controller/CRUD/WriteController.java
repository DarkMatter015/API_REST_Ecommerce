package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

// T = tipo da classe (User, Category...), D = tipo do DTO (Request, Response), ID = atributo da chave primária da classe
public abstract class WriteController<T, D, RD, ID extends Serializable> {
    protected abstract ICrudRequestService<T, ID> getService();
    protected abstract ICrudResponseService<T, ID> getResponseService();
    protected abstract ModelMapper getModelMapper();

    private final Class<T> typeClass;
    private final Class<D> typeDtoClass;
    private final Class<RD> typeDtoResponseClass;

    public WriteController(Class<T> typeClass, Class<D> typeDtoClass, Class<RD> typeDtoResponseClass) {
        this.typeClass = typeClass;
        this.typeDtoClass = typeDtoClass;
        this.typeDtoResponseClass = typeDtoResponseClass;
    }

//    Generaliza o mapeamento de Entidades
    private <S, T> T map(S source, Class<T> destinationType) {
        return getModelMapper().map(source, destinationType);
    }

    @PostMapping
    public ResponseEntity<RD> create(@RequestBody @Valid D entityDto) {
        T entity = map(entityDto, this.typeClass);
        T savedEntity = getService().save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(map(savedEntity, this.typeDtoResponseClass));
    }

    @PutMapping("{id}")
    public ResponseEntity<RD> update(@PathVariable ID id, @RequestBody @Valid D entityDto) {

        T existingEntity = getResponseService().findById(id);

        // Mapeia os dados do DTO para a entidade existente.
        map(entityDto, existingEntity.getClass());

        // Salva a entidade atualizada.
        T updatedEntity = getService().save(existingEntity);

        return ResponseEntity.status(HttpStatus.OK).body(map(updatedEntity, this.typeDtoResponseClass));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

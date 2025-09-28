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

    private D convertToDto(T entity) {
        return getModelMapper().map(entity, this.typeDtoClass);
    }

    private T convertToEntity(D entityDto) {
        return getModelMapper().map(entityDto, this.typeClass);
    }

    private RD convertToDtoResponse(T entity) {
        return getModelMapper().map(entity, this.typeDtoResponseClass);
    }

    private T convertResponseToEntity(RD entityDtoResponse) {
        return getModelMapper().map(entityDtoResponse, this.typeClass);
    }

    @PostMapping
    public ResponseEntity<RD> create(@RequestBody @Valid D entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDtoResponse(getService().save(convertToEntity(entity))));
    }

    @PutMapping("{id}")
    public ResponseEntity<RD> update(@PathVariable ID id, @RequestBody @Valid D entity) {

        T object = getResponseService().findById(id);
        if (object == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(convertToDtoResponse(getService().save(convertToEntity(entity))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

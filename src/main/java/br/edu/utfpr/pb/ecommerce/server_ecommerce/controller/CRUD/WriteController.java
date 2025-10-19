package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

// T = class type (User, Category...), D = DTO type (Request), RD = DTO type (Response), UD = DTO type (Update), ID = primary key attribute of the class
public abstract class WriteController<T, D, RD, UD, ID extends Serializable> {

    private final ICrudRequestService<T, UD, ID> service;
    protected final ModelMapper modelMapper; // 'protected' to be used by 'hooks'

    private final Class<T> typeClass;
    private final Class<RD> typeDtoResponseClass;

    public WriteController(ICrudRequestService<T, UD, ID> service,
                           ModelMapper modelMapper,
                           Class<T> typeClass,
                           Class<RD> typeDtoResponseClass) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.typeClass = typeClass;
        this.typeDtoResponseClass = typeDtoResponseClass;
    }

    // ResponseDTO ==> Entity
    protected T convertToEntity(D createDto) {
        return modelMapper.map(createDto, this.typeClass);
    }

    // Entity ==> ResponseDTO
    protected RD convertToResponseDto(T entity) {
        return modelMapper.map(entity, this.typeDtoResponseClass);
    }

    @PostMapping
    public ResponseEntity<RD> create(@RequestBody @Valid D entityDto) {
        T entity = convertToEntity(entityDto);
        T savedEntity = service.save(entity);

        RD responseDto = convertToResponseDto(savedEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<RD> update(@PathVariable ID id, @RequestBody @Valid UD entityDto) {

        T updatedEntity = this.service.update(id, entityDto);

        RD responseDto = convertToResponseDto(updatedEntity);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

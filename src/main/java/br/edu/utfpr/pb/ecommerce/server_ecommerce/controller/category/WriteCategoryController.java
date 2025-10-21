package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.category;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.iCategory.ICategoryRequestService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
@RolesAllowed({"ADMIN"})
public class WriteCategoryController extends WriteController<Category, CategoryRequestDTO, CategoryResponseDTO, CategoryUpdateDTO, Long> {
    public WriteCategoryController(ICategoryRequestService service, ModelMapper modelMapper) {
        super(service, modelMapper, Category.class, CategoryResponseDTO.class);
    }

    @Override
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody @Valid CategoryRequestDTO entityDto) {
        return super.create(entityDto);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CategoryUpdateDTO entityDto) {
        return super.update(id, entityDto);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}

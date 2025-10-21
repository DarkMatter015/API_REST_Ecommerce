package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.iCategory;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface ICategoryRequestService extends ICrudRequestService<Category, CategoryUpdateDTO, Long> {
}

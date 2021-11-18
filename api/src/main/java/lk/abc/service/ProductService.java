package lk.abc.service;

import lk.abc.dto.ProductDTO;

import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/
public interface ProductService {

    void save(ProductDTO dto);

    void update(ProductDTO dto);

    void delete(String id);

    ArrayList<ProductDTO> getAllProducts();

    ProductDTO searchById(String id);

    ArrayList<ProductDTO> getAllByCategory(String id);

}

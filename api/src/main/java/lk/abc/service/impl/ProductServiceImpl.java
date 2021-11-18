package lk.abc.service.impl;

import lk.abc.dto.ProductDTO;
import lk.abc.entity.Product;
import lk.abc.exception.NotFoundException;
import lk.abc.exception.ValidateException;
import lk.abc.repo.ProductRepo;
import lk.abc.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(ProductDTO dto) {
        if (repo.existsById(dto.getProductID())){
            throw new ValidateException("ID already exist");
        }
        repo.save(mapper.map(dto,Product.class));
    }

    @Override
    public void update(ProductDTO dto) {
        if (repo.existsById(dto.getProductID())){
            System.out.println(mapper.map(dto,Product.class));
            repo.save(mapper.map(dto,Product.class));
        }else {
            throw new NotFoundException("ID does not exist");
        }

    }

    @Override
    public void delete(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new NotFoundException("ID does not exist");
        }
    }

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductDTO searchById(String id) {
        Optional<Product> product = repo.findById(id);
        if (product.isPresent()){
            return mapper.map(product.get(),ProductDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ProductDTO> getAllByCategory(String id) {
        List<Product> products = repo.getAllByCategory_CategoryID(id);
            return mapper.map(products,new TypeToken<ArrayList<ProductDTO>>(){}.getType());

    }
}

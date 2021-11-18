package lk.abc.service.impl;

import lk.abc.dto.CategoryDTO;
import lk.abc.entity.Category;
import lk.abc.exception.ValidateException;
import lk.abc.repo.CategoryRepo;
import lk.abc.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(CategoryDTO dto) {
        if (repo.existsById(dto.getCategoryID())){
            throw new ValidateException("ID already exist");
        }
        repo.save(mapper.map(dto,Category.class));
    }

    @Override
    public void update(CategoryDTO dto) {
        if (!repo.existsById(dto.getCategoryID())){
            throw new ValidateException("ID does not exist");
        }
        repo.save(mapper.map(dto,Category.class));
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)){
            throw new ValidateException("ID does not exist");
        }
        repo.deleteById(id);
    }

    @Override
    public ArrayList<CategoryDTO> getAllCategories() {
        List<Category> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }

    @Override
    public CategoryDTO searchById(String id) {
        return null;
    }
}

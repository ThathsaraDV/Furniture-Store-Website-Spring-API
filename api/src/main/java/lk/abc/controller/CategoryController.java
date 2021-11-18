package lk.abc.controller;

import lk.abc.dto.CategoryDTO;
import lk.abc.exception.ValidateException;
import lk.abc.service.CategoryService;
import lk.abc.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCategory(@RequestBody CategoryDTO dto){
        if (dto.getCategoryID().isEmpty()){
            throw new ValidateException("Required fields are empty");
        }
        categoryService.save(dto);
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCategory(@RequestBody CategoryDTO dto){
        if (dto.getCategoryID().isEmpty()){
            throw new ValidateException("Required fields are empty");
        }
        categoryService.update(dto);
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.OK);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCategory(@RequestBody CategoryDTO dto){
        if (dto.getCategoryID() == null){
            throw new ValidateException("Id required");
        }
        categoryService.delete(dto.getCategoryID());
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCategories(){
        ArrayList<CategoryDTO> allCategories = categoryService.getAllCategories();
        return new ResponseEntity(new StandardResponse("200","Success",allCategories),HttpStatus.OK);
    }

}

package lk.abc.controller;

import lk.abc.dto.ProductDTO;
import lk.abc.exception.ValidateException;
import lk.abc.service.ProductService;
import lk.abc.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductDTO dto){
        if (dto.getProductID().isEmpty()){
            throw new ValidateException("Required fields are empty");
        }
        System.out.println(dto);
        productService.save(dto);
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody ProductDTO dto){
        if (dto.getProductID().isEmpty()){
            throw new ValidateException("Required fields are empty");
        }
        productService.update(dto);
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.OK);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@RequestBody ProductDTO dto){
        if (dto == null){
            throw new ValidateException("Id required");
        }
        productService.delete(dto.getProductID());
        return new ResponseEntity(new StandardResponse("200","Success",dto.getProductID()),HttpStatus.OK);
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllByCategory(@RequestParam String id){
        if (id == null){
            throw new ValidateException("Id required");
        }
        ArrayList<ProductDTO> allByCategory = productService.getAllByCategory(id);
        return new ResponseEntity(new StandardResponse("200","Success",allByCategory),HttpStatus.OK);
    }

    @GetMapping(params = {"productID"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductByID(@RequestParam String productID){
        if (productID == null){
            throw new ValidateException("Id required");
        }
        ProductDTO productDTO = productService.searchById(productID);
        return new ResponseEntity(new StandardResponse("200","Success",productDTO),HttpStatus.OK);
    }



    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFile(@RequestPart("myFile") MultipartFile myFile) {

        String parts[] = myFile.getOriginalFilename().split("_");
        String id = parts[0];
        String category = parts[1];

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            File uploadsDir = new File(projectPath + "/upload/products/"+category+"/"+id);

            uploadsDir.mkdirs();

            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            String imgPath = "../upload/products/"+category+"/"+ id +"/"+ myFile.getOriginalFilename();
            System.out.println(imgPath);

            return new ResponseEntity(new StandardResponse("200","Success",imgPath),HttpStatus.OK);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity(new StandardResponse("500",e.getMessage(),null),HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(new StandardResponse("500",e.getMessage(),null),HttpStatus.OK);
        }

    }

}

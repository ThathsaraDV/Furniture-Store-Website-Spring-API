package lk.abc.controller;

import lk.abc.dto.UserDTO;
import lk.abc.exception.ValidateException;
import lk.abc.service.UserService;
import lk.abc.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody UserDTO dto){
        if (dto.getUserID().isEmpty()){
            throw new ValidateException("Required fields are empty");
        }
        System.out.println(dto);
        userService.save(dto);
        return new ResponseEntity(new StandardResponse("200","Success",dto),HttpStatus.CREATED);
    }

    @GetMapping(params = {"email"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllByCategory(@RequestParam String email){
        if (email == null){
            throw new ValidateException("email required");
        }
        UserDTO user = userService.findUserByEmail(email);
        return new ResponseEntity(new StandardResponse("200","Success",user),HttpStatus.OK);
    }

}

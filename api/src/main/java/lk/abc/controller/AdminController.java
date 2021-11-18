package lk.abc.controller;

import lk.abc.dto.AdminDTO;
import lk.abc.exception.ValidateException;
import lk.abc.service.AdminService;
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
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(params = {"userName"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllByCategory(@RequestParam String userName){
        if (userName == null){
            throw new ValidateException("Username required");
        }
        AdminDTO adminDTO = adminService.findAdminByUserName(userName);
        return new ResponseEntity(new StandardResponse("200","Success",adminDTO),HttpStatus.OK);
    }

}

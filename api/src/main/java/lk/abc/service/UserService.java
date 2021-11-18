package lk.abc.service;

import lk.abc.dto.UserDTO;

import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/
public interface UserService {

    void save(UserDTO dto);

    void update(UserDTO dto);

    void delete(String id);

    ArrayList<UserDTO> getAllUsers();

    UserDTO searchById(String id);

    UserDTO findUserByEmail(String email);

}

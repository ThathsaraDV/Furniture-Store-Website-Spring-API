package lk.abc.service;

import lk.abc.dto.AdminDTO;

import java.util.ArrayList;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/
public interface AdminService {

    void save(AdminDTO dto);

    void update(AdminDTO dto);

    void delete(String id);

    ArrayList<AdminDTO> getAllAdmins();

    AdminDTO searchById(String id);

    AdminDTO findAdminByUserName(String name);

}

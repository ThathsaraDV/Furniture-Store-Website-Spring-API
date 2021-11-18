package lk.abc.service.impl;

import lk.abc.dto.AdminDTO;
import lk.abc.entity.Admin;
import lk.abc.repo.AdminRepo;
import lk.abc.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(AdminDTO dto) {

    }

    @Override
    public void update(AdminDTO dto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() {
        return null;
    }

    @Override
    public AdminDTO searchById(String id) {
        return null;
    }

    @Override
    public AdminDTO findAdminByUserName(String name) {
        Optional<Admin> adminByUserName = repo.findAdminByUserName(name);
        if (adminByUserName.isPresent()){
            return mapper.map(adminByUserName.get(),AdminDTO.class);
        }

        return null;
    }
}

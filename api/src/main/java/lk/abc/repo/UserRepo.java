package lk.abc.repo;

import lk.abc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/
public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findUserByEmail(String email);


}

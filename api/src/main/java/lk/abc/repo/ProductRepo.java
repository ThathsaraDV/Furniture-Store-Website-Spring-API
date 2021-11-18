package lk.abc.repo;

import lk.abc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/
public interface ProductRepo extends JpaRepository<Product,String> {

    List<Product> getAllByCategory_CategoryID(String categoryID);

}
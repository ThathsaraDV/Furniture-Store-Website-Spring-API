package lk.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

    @Id
    private String adminID;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}

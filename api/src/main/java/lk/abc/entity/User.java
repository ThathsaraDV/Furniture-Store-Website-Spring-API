package lk.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String userID;
    private String name;
    private String email;
    private String password;

}

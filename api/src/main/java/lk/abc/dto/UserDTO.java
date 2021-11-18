package lk.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String userID;
    private String name;
    private String email;
    private String password;

}

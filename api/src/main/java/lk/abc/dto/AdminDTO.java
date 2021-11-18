package lk.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {

    private String adminID;
    private String userName;
    private String password;

}

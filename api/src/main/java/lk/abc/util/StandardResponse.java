package lk.abc.util;

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
public class StandardResponse {

    private String code;
    private String message;
    private Object data;

}

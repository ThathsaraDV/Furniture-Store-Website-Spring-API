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
public class ProductDTO {

    private String productID;
    private String name;
    private String code;
    private String price;
    private String description;
    private String specs;
    private String dimensions;
    private String warranty;
    private String mainImg;
    private String img1;
    private String img2;
    private String img3;
    private AdminDTO admin;
    private CategoryDTO category;

}

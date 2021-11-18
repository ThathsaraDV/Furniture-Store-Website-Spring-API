package lk.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/20/2021
 **/

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    private String productID;
    private String name;
    private String code;
    private String price;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String specs;
    @Column(columnDefinition = "LONGTEXT")
    private String dimensions;
    @Column(columnDefinition = "LONGTEXT")
    private String warranty;
    private String mainImg;
    private String img1;
    private String img2;
    private String img3;

    @ManyToOne
    @JoinColumn(name = "adminID", referencedColumnName = "adminID"/*,insertable = false,updatable = false*/)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID"/*,insertable = false,updatable = false*/)
    private Category category;


}

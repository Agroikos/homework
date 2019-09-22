package week7;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

//TODO: Why exactly am I implementing Serializable?

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product implements Serializable {
    /*
    `productCode` varchar(15) NOT NULL,
    `productName` varchar(70) NOT NULL,
    `productLine` varchar(50) NOT NULL,
    `productScale` varchar(10) NOT NULL,
    `productVendor` varchar(50) NOT NULL,
    `productDescription` text NOT NULL,
    `quantityInStock` smallint(6) NOT NULL,
    `buyPrice` decimal(10,2) NOT NULL,
    `MSRP` decimal(10,2) NOT NULL,
    */

    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;



}

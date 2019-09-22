package week7;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order implements Serializable {
    /*
    `orderNumber` int(11) NOT NULL,
    `orderDate` date NOT NULL,
    `requiredDate` date NOT NULL,
    `shippedDate` date DEFAULT NULL,
    `status` varchar(15) NOT NULL,
    `comments` text,
    `customerNumber` int(11) NOT NULL,
    */

    private BigInteger orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String status;
    private String comments;
    private BigInteger customerNumber;

}

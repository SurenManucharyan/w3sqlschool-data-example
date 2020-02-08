package com.example.sql.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "best_sale", query = "CALL best_sale()",
                resultClass = BestSale.class)
})
public class BestSale implements Serializable {
    @Id
    @Column(name = "order_details_id")
    private Integer orderDetailsId;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "total_price")
    private double totalPrice;
}

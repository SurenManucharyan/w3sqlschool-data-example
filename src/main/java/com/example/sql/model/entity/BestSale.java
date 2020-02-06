package com.example.sql.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@Getter
@Setter
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(procedureName ="best_sale" ,
        name = "bestSale",
        resultClasses = BestSale.class)
})
public class BestSale {
    @Id
    private Integer orderDetailsId;
    private Integer totalQuantity;
    private Integer productId;
    private String productName;
    private double totalPrice;
}

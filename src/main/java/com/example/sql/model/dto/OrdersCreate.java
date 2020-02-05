package com.example.sql.model.dto;

import com.example.sql.model.entity.OrderDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrdersCreate {
    private Date orderDate;
    private Integer employeeId;
    private Integer customerId;
    private Integer shipperId;
    private List<OrderDetailDto> orderDetailDto;
}

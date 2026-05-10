package order_service.dto;

import lombok.*;

@Data
public class CreateOrderRequest {

    private Long userId;
    private String productName;
    private int quantity;
}

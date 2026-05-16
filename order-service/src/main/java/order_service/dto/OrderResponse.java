package order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private UserResponse user;

}

package order_service.mapper;

import order_service.dto.OrderResponse;
import order_service.dto.UserResponse;
import order_service.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order, UserResponse user){
        return new OrderResponse(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                user
        );
    }

}

package order_service.service;

import lombok.RequiredArgsConstructor;
import order_service.client.UserClient;
import order_service.dto.CreateOrderRequest;
import order_service.dto.OrderResponse;
import order_service.dto.UserResponse;
import order_service.entity.Order;
import order_service.mapper.OrderMapper;
import order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserClient userClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponse createOrder(CreateOrderRequest request){

        UserResponse user = userClient.getResponse(request.getUserId());

        if(user == null){
            throw new RuntimeException("User not found");
        }

        Order order = new Order();
        order.setUserId(user.id());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());

        Order saved = orderRepository.save(order);

       return orderMapper.toResponse(saved,user);
    }

    public OrderResponse getOrderById(Long id){

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        UserResponse user = userClient.getResponse((order.getUserId()));

        return orderMapper.toResponse(order,user);

    }

}

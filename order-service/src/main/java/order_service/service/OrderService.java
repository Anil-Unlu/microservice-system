package order_service.service;

import lombok.RequiredArgsConstructor;
import order_service.client.ProductClient;
import order_service.client.UserClient;
import order_service.dto.CreateOrderRequest;
import order_service.dto.OrderResponse;
import order_service.dto.ProductResponse;
import order_service.dto.UserResponse;
import order_service.entity.Order;
import order_service.exception.OrderNotFoundException;
import order_service.mapper.OrderMapper;
import order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserClient userClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;

    public OrderResponse createOrder(CreateOrderRequest request){

        UserResponse user = userClient.getResponse(request.getUserId());

        productClient.reduceStock(request.getProductId(), request.getQuantity());

        Order order = new Order();
        order.setUserId(user.id());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());

        Order saved = orderRepository.save(order);
        ProductResponse product = productClient.getProductById(request.getProductId());

       return orderMapper.toResponse(saved,user,product);
    }

    public OrderResponse getOrderById(Long id){

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        UserResponse user = userClient.getResponse((order.getUserId()));
        ProductResponse product = productClient.getProductById(order.getProductId());

        return orderMapper.toResponse(order,user, product);

    }

}

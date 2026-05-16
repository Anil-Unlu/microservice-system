package order_service.client;

import order_service.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product-service", url="http://localhost:8082")
public interface ProductClient {

    @PutMapping("/api/products/{id}/reduce-stock")
    void reduceStock(@PathVariable Long id, @RequestParam Integer quantity);

    @GetMapping("/api/products/{id}")
    ProductResponse getProductById(@PathVariable Long id);

}

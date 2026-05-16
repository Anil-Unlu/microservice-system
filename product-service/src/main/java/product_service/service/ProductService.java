package product_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import product_service.dto.ProductRequest;
import product_service.dto.ProductResponse;
import product_service.entity.Product;
import product_service.exception.ProductNotFoundException;
import product_service.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
        Product saved = productRepository.save(product);
        return toResponse(saved);
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
        return toResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        return toResponse(productRepository.save(product));
    }

    public void deleteProduct(Long id){
        productRepository.findById(id)
                        .orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
        productRepository.deleteById(id);
    }

    public void reduceStock(Long productId, Integer quantity){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
        if(product.getStock()< quantity){
            throw new RuntimeException("Insufficient Stock");
        }

        product.setStock(product.getStock()-quantity);
        productRepository.save(product);

    }

    private ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

}

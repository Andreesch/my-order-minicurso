package com.app.myorder.services;

import com.app.myorder.api.dtos.product.ProductCreateDto;
import com.app.myorder.api.dtos.product.ProductUpdateDto;
import com.app.myorder.api.mappers.ProductMapper;
import com.app.myorder.config.Translator;
import com.app.myorder.entities.Product;
import com.app.myorder.entities.Restaurant;
import com.app.myorder.exceptions.NotFoundException;
import com.app.myorder.repositories.ProductRepository;
import com.app.myorder.repositories.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSearchRepository productSearchRepository;

    @Autowired
    private RestaurantService restaurantService;

    public Product create(ProductCreateDto productCreateDto) {
        return productRepository.save(
                createProduct(productCreateDto));
    }

    public List<Product> findAllById(List<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public List<Product> listByRestaurantId(Integer restaurantId) {
        return productSearchRepository.findByRestaurantId(restaurantId);
    }

    public void updateProduct(ProductUpdateDto productUpdateDto) {
        findById(productUpdateDto.getId());

        productRepository.save(ProductMapper.toEntity(productUpdateDto));
    }

    public void deleteProduct(Integer id) {
        productRepository.delete(findById(id));
    }

    private Product createProduct(ProductCreateDto productCreateDto) {
        return ProductMapper
                .toEntity(productCreateDto)
                .setRestaurant(findProductRestaurant(productCreateDto.getRestaurantId()));
    }

    private Restaurant findProductRestaurant(Integer restaurantId) {
        return restaurantService.findRestaurantById(restaurantId);
    }

    private Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("product.notfound.exception", new Integer[]{id})));
    }
}

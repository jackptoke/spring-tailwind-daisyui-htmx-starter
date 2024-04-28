package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.ProductDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface ProductApi {
    @GetExchange()
    List<ProductDto> getProducts(@RequestParam(name = "limit", required = false) int limit, @RequestParam(name = "sort", required = false) String sort);
    @GetExchange("/{id}")
    ProductDto getProduct(@PathVariable("id") Long id);
    @GetExchange("/categories")
    List<String> getCategories();
    @GetExchange("/category/{category}")
    List<ProductDto> getProductsByCategory(@PathVariable("category") String category);
    @PostExchange
    List<ProductDto> addProduct(@RequestBody ProductDto productDto);
    @PutExchange("/{id}")
    ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto);
    @DeleteExchange("/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}

package com.ecomm.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomm.model.product.Product;
import com.ecomm.model.product.ProductResponse;

@FeignClient(name="ecomm-product-service")
@RibbonClient(name="ecomm-product-service")
public interface ProductContract {

	@GetMapping("/product/getProducts")
	public List<Product> getProductList();

	@GetMapping("/product/getProduct/{productId}")
	public ProductResponse getProduct(@PathVariable("productId") int productId);

	@PostMapping("/product/addProduct")
	public ProductResponse addProduct(@RequestBody Product product);
	
	@PutMapping("/product/updateProduct")
	public ProductResponse updateProduct(@RequestBody Product product);

	@DeleteMapping("/product/deleteProduct/{productId}")
	public ProductResponse deleteProduct(@PathVariable("productId") int productId);
}


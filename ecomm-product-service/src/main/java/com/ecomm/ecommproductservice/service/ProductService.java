package com.ecomm.ecommproductservice.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.ecommproductservice.exceptions.ResourceNotException;
import com.ecomm.ecommproductservice.model.ProductEntity;
import com.ecomm.ecommproductservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public List<ProductEntity> getProductList() {
		logger.info("*****ProductService***** getProductList");
		
		List<ProductEntity> products = productRepository.findAll();
		
		return products;		
	}
	
	public ProductEntity getProduct(Integer productId) {
		
		logger.info("*****ProductService***** productId: " + productId);
		
		ProductEntity productEntity = productRepository.findOne(productId);
		if(productEntity == null)		
			throw new ResourceNotException("Product has not found for give product id: " + productId);
		
		return productEntity;
	}
	
	public void saveProduct(ProductEntity productEntity) throws Exception {
		logger.info("*****ProductService***** saveProduct");
		
		this.productRepository.save(productEntity);
		
	}
	
	public void updateProduct(ProductEntity productEntity) {
		
		logger.info("*****ProductService***** updateProduct");
		
		Integer productId = productEntity.getProductId();
		
		ProductEntity productEntityDB = productRepository.findOne(productId);
		if(productEntityDB == null)		
			throw new ResourceNotException("Product has not found for give product id: " + productId);
		
		this.productRepository.save(productEntity);
		
	}
	
	public void deleteProduct(Integer productId) {
		
		logger.info("*****ProductService***** productId: " + productId);
		
		ProductEntity productEntity = productRepository.findOne(productId);
		if(productEntity == null)
			throw new ResourceNotException("Product has not found for give product id: " + productId);
			
		this.productRepository.delete(productId);
	}
}

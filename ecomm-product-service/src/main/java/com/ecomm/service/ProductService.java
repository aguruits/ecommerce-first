package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.dao.ProductEntity;
import com.ecomm.dao.ProductRepository;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.ResourceNotException;
import com.ecomm.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public List<Product> getProductList() {
		
		logger.info("*****getProductList*****");
		
		List<ProductEntity> productEntities = productRepository.findAll();
		
		List<Product> products = new ArrayList<Product>();
		if(productEntities != null && productEntities.size()>0) {
			products = productEntities.stream()
						.map(pe -> new Product(pe.getProductId(), pe.getProductCode(), pe.getName(), pe.getPrice(), pe.getAvailableQuantity(), pe.getCreateDate()))
						.collect(Collectors.toList());
		}
		
		return products;		
	}
	
	public Product getProduct(Integer productId) {
		
		logger.info("*****ProductRepository***** productId: " + productId);
		Product product = new Product();
		
		if(productId == null) {
			logger.info("*****getProduct***** productId is null: ");
			throw new EcommException("Product Id should not be null.");
		} else {
		
			ProductEntity productEntity = productRepository.findOne(productId);
			if(productEntity != null) {
				BeanUtils.copyProperties(productEntity, product);
			} else if(productEntity == null) {	
				logger.info("*****ProductRepository***** No Product found for given productId: " + productId);
				throw new ResourceNotException("Product has not found for give product id: " + productId);
			} 
		}
		return product;
	}
	
	public void saveProduct(Product product) throws Exception {
		logger.info("*****saveProduct*****");
		if(product == null) {
			logger.info("*****productEntity should not be null*****");
			throw new EcommException("ProductEntity should not be null.");
		} else {
			ProductEntity pe = new ProductEntity();
			BeanUtils.copyProperties(product, pe);
			this.productRepository.save(pe);
			logger.info("*****updateProduct***** Product inserted successfully ");
		}
		
	}
	
	public void updateProduct(Product product) {
		
		logger.info("*****updateProduct*****");
		
		Integer productId = product.getProductId();
		logger.info("*****updateProduct***** productId: " + productId);
		if(productId == null) {
			logger.info("*****getProduct***** productId is null: ");
			throw new EcommException("Product Id should not be null.");
		} else {
			ProductEntity productEntityDB = productRepository.findOne(productId);
			if(productEntityDB == null)	{	
				logger.info("*****updateProduct***** No Product found for given productId: " + productId);
				throw new ResourceNotException("Product has not found for give product id: " + productId);
			} else {
				ProductEntity productEntity = new ProductEntity();
				BeanUtils.copyProperties(product, productEntity);
				
				this.productRepository.save(productEntity);
				logger.info("*****updateProduct***** Product updated successfully ");
			}
		}
		
	}
	
	public void deleteProduct(Integer productId) {
		
		logger.info("*****deleteProduct***** productId: " + productId);
		
		if(productId == null) {
			logger.info("*****getProduct***** productId is null: ");
			throw new EcommException("Product Id should not be null.");
		} else {
			ProductEntity productEntity = productRepository.findOne(productId);
			if(productEntity == null) {
				logger.info("*****ProductRepository***** No Product found for given productId: " + productId);
				throw new ResourceNotException("Product has not found for give product id: " + productId);
			}
				
			this.productRepository.delete(productId);
			logger.info("*****updateProduct***** Product deleted successfully ");
		}
	}
}

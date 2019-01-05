package com.ecomm.ecommproductservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ecomm.ecommproductservice.model.Product;

@Repository
public class ProductDAO {
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	public List<Product> getAllProducts() {
		return initializeProducts();
	}
	
	public List<Product> getProductsbyCatalog(String productCatalog) {
		List<Product> products = initializeProducts();
		
		List<Product> filterProduct = products.stream()
										.filter(p -> p.getProductCatalog().equalsIgnoreCase(productCatalog))
										.map(p ->  new Product(p.getProductId(), p.getProductCode(), p.getProductName(), p.getProductDesc(), p.getPrice(), p.getUnitsInStock(), p.getProductCatalog()))
										.collect(Collectors.toList());
		logger.info("filterProduct..." + filterProduct.size());			
		if(filterProduct.size() == 0) {
			return null;
		} else {
			return filterProduct;
		}	
		
	}
	
	public Product getProduct(int productId) {
		
		List<Product> products = initializeProducts();
		
		List<Product> filterProduct = (List<Product>) products.stream()
							.filter(p -> p.getProductId() == productId)
							.map(p ->  new Product(p.getProductId(), p.getProductCode(), p.getProductName(), p.getProductDesc(), p.getPrice(), p.getUnitsInStock(), p.getProductCatalog()))
							.collect(Collectors.toList());
		logger.info("filterProduct..." + filterProduct.size());			
		if(filterProduct.size() == 0) {
			return null;
		} else {
			return filterProduct.get(0);
		}	
	}
	
	private List<Product> initializeProducts() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(1, "LM1000", "LENOVO", "Lenovo l230", 5000, 10000, "Mobile"));
		products.add(new Product(2, "AM1000", "APPLE", "Apple i9", 30000, 25000, "Mobile"));
		products.add(new Product(3, "DL1000", "DELL", "Dell Inspiration Core i5", 65000, 9000, "Laptop"));
		products.add(new Product(4, "AL1000", "APPLE", "Apple i6 8th Gen", 90000, 3400, "Laptop"));
		
		return products;
	}

}

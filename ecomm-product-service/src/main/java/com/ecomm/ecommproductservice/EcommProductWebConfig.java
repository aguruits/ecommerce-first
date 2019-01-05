package com.ecomm.ecommproductservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.ecomm.ecommproductservice.model.ProductEntity;
import com.ecomm.ecommproductservice.repository.ProductRepository;

@Configuration
@ComponentScan
public class EcommProductWebConfig {

	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		logger.info("**************Start of inserting product details...");
		
		List<ProductEntity> productEntityList = getProductEntityList();
		for(ProductEntity productEntity: productEntityList) {
			productRepository.save(productEntity);
		}
		
		logger.info("*************End of inserting product details...");
    }
	 
	 private List<ProductEntity> getProductEntityList() {
		 List<ProductEntity> productEntityList = new ArrayList<>();
		 
		 ProductEntity pe1 = new ProductEntity();
		 pe1.setProductId(1);
		 pe1.setProductCode("LM1000");
		 pe1.setProductName("LENOVO");
		 pe1.setProductDesc("Lenovo l230");
		 pe1.setPrice(5000);
		 pe1.setUnitsInStock(10000);
		 pe1.setProductCatalog("Mobile");
		 productEntityList.add(pe1);
		 
		 
		 ProductEntity pe2 = new ProductEntity();
		 pe2.setProductId(2);
		 pe2.setProductCode("AM1000");
		 pe2.setProductName("APPLE");
		 pe2.setProductDesc("Apple i9");
		 pe2.setPrice(30000);
		 pe2.setUnitsInStock(25000);
		 pe2.setProductCatalog("Mobile");
		 productEntityList.add(pe2);
		 
		 ProductEntity pe3 = new ProductEntity();
		 pe3.setProductId(3);
		 pe3.setProductCode("DL1000");
		 pe3.setProductName("DELL");
		 pe3.setProductDesc("Dell Inspiration Core i5");
		 pe3.setPrice(65000);
		 pe3.setUnitsInStock(9000);
		 pe3.setProductCatalog("Laptop");
		 productEntityList.add(pe3);
		 
		 ProductEntity pe4 = new ProductEntity();
		 pe4.setProductId(4);
		 pe4.setProductCode("AL1000");
		 pe4.setProductName("APPLE");
		 pe4.setProductDesc("Apple i6 8th Gen");
		 pe4.setPrice(90000);
		 pe4.setUnitsInStock(3400);
		 pe4.setProductCatalog("Laptop");
		 productEntityList.add(pe4);
		 
		 
		return productEntityList;
	 }
}


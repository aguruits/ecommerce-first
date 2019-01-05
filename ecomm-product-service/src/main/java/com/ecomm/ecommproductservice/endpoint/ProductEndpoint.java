package com.ecomm.ecommproductservice.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.ecommproductservice.exceptions.EcommException;
import com.ecomm.ecommproductservice.model.ProductEntity;
import com.ecomm.ecommproductservice.model.ResponseMessage;
import com.ecomm.ecommproductservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductEndpoint {

	@Autowired
	ProductService productService;
	
	@GetMapping("/getProducts")
	public List<ProductEntity> getProductList() {
		return productService.getProductList();
	}

	@GetMapping("/getProduct/{productId}")
	public ProductEntity getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	}

	@PostMapping("/addProduct")
	public ResponseMessage addProduct(@RequestBody ProductEntity productDetailModel) {
		
		try { 
			this.productService.saveProduct(productDetailModel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EcommException("Error occurred while inserting product details into the Table");
		}
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setResponeStatus("Success");
		responseMessage.setResponseCode("00");
		responseMessage.setResponseDesc("Your Product hase been inserted successfully.");
		return responseMessage;
	}
	
	@PutMapping("/updateProduct")
	public ResponseMessage updateProduct(@RequestBody ProductEntity productDetailModel) {
		this.productService.updateProduct(productDetailModel);;
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setResponeStatus("Success");
		responseMessage.setResponseCode("00");
		responseMessage.setResponseDesc("Product details updated successfully.");
		return responseMessage;
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseMessage deleteProduct(@PathVariable("productId") int productId) {
		this.productService.deleteProduct(productId);;
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setResponeStatus("Success");
		responseMessage.setResponseCode("00");
		responseMessage.setResponseDesc("Product details has been deleted successfully.");
		return responseMessage;
	}
}
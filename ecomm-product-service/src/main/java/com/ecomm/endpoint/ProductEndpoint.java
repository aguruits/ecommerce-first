package com.ecomm.endpoint;

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

import com.ecomm.exception.EcommException;
import com.ecomm.model.Product;
import com.ecomm.model.ProductResponse;
import com.ecomm.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductEndpoint {

		@Autowired
		ProductService productService;
		
		@GetMapping("/getProducts")
		public List<Product> getProductList() {
			return productService.getProductList();
		}

		@GetMapping("/getProduct/{productId}")
		public ProductResponse getProduct(@PathVariable("productId") int productId) {
			
			Product product = new Product();
			
			product = productService.getProduct(productId);
			
			ProductResponse responseMessage = new ProductResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Your Product Found.");
			responseMessage.setProduct(product);;
			
			return responseMessage;
		}

		@PostMapping("/addProduct")
		public ProductResponse addProduct(@RequestBody Product productDetailModel) {
			
			try { 
				this.productService.saveProduct(productDetailModel);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while inserting product details into the Table");
			}
			
			ProductResponse responseMessage = new ProductResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Your Product hase been inserted successfully.");
			return responseMessage;
		}
		
		@PutMapping("/updateProduct")
		public ProductResponse updateProduct(@RequestBody Product productDetailModel) {
			
			try { 
				this.productService.updateProduct(productDetailModel);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while updating product details.");
			}
			
			ProductResponse responseMessage = new ProductResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Product details updated successfully.");
			return responseMessage;
		}

		@DeleteMapping("/deleteProduct/{productId}")
		public ProductResponse deleteProduct(@PathVariable("productId") int productId) {
			
			try { 
				this.productService.deleteProduct(productId);;
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while deleting product details.");
			}
			
			
			ProductResponse responseMessage = new ProductResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("Product details has been deleted successfully.");
			return responseMessage;
		}
	}


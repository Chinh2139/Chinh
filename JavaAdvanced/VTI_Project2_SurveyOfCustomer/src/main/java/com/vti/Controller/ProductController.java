package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.ProductDto;
import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;
import com.vti.Service.ProductService;

@RestController
@RequestMapping(value = "api/v3/RequestToProducts")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService productService;

// get all product
	@GetMapping()
	public ResponseEntity<?> getAllProduct() {
		List<Product> products = productService.getAllproduct();
		List<ProductDto> productDtos = new ArrayList<>();
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName().toString());
			productDto.setPrice(product.getPrice());
			productDto.setInfo(product.getInfo());
			productDto.setDetail(product.getDetail());
			productDto.setRatingStar(product.getRatingStar());
			productDto.setImageName(product.getImageName());
			productDto.setManufacturerName(product.getManufacturer().getName().toString());
			productDtos.add(productDto);

		}
		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

	// get product by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name = "id") short id) {
		try {
			Product product = productService.getProductById(id);
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			productDto.setInfo(product.getInfo());
			productDto.setDetail(product.getDetail());
			productDto.setRatingStar(product.getRatingStar());
			productDto.setImageName(product.getImageName());
			productDto.setManufacturerName(product.getManufacturer().getName().toString());

			return new ResponseEntity<>(productDto, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Not Found", HttpStatus.OK);

	}

	// add new product
	@PostMapping()
	public ResponseEntity<?> creatNewProduct(@RequestBody ProductFormForCreating newProductForm) {
		try {
			Product newpProduct = productService.creatNewProduct(newProductForm);
			ProductDto productDto = new ProductDto();
			productDto.setId(newpProduct.getId());
			productDto.setName(newpProduct.getName());
			productDto.setPrice(newpProduct.getPrice());
			productDto.setInfo(newpProduct.getInfo());
			productDto.setDetail(newpProduct.getDetail());
			productDto.setRatingStar(newpProduct.getRatingStar());
			productDto.setImageName(newpProduct.getImageName());
			productDto.setManufacturerName(newpProduct.getManufacturer().getName().toString());
			return new ResponseEntity<>(productDto, HttpStatus.CREATED);
		} catch (Exception e) {
			;
			// TODO: handle exception
		}
		return new ResponseEntity<>("Can't Create New Product", HttpStatus.BAD_REQUEST);

	}

	// update product
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") short id,
			@RequestBody ProductFormForUpdating updatingForm) {
		try {
			Product productUpdate = productService.updateProduct(id, updatingForm);
			ProductDto productDto = new ProductDto();
			productDto.setId(productUpdate.getId());
			productDto.setName(productUpdate.getName());
			productDto.setPrice(productUpdate.getPrice());
			productDto.setInfo(productUpdate.getInfo());
			productDto.setDetail(productUpdate.getDetail());
			productDto.setRatingStar(productUpdate.getRatingStar());
			productDto.setImageName(productUpdate.getImageName());
			productDto.setManufacturerName(productUpdate.getManufacturer().getName().toString());
			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

	}

	// Delete product
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteProduct(@PathVariable(name = "id") short id) {
		try {
			Product deleteProduct = productService.getProductById(id);
			// Chuyển đổi dữ liệu
			ProductDto productDto = new ProductDto();
			productDto.setId(deleteProduct.getId());
			productDto.setName(deleteProduct.getName());
			productDto.setPrice(deleteProduct.getPrice());
			productDto.setInfo(deleteProduct.getInfo());
			productDto.setDetail(deleteProduct.getDetail());
			productDto.setRatingStar(deleteProduct.getRatingStar());
			productDto.setImageName(deleteProduct.getImageName());
			productDto.setManufacturerName(deleteProduct.getManufacturer().getName().toString());

			// Thực hiện delete product
			productService.deleteProductById(id);
			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);

	}
}

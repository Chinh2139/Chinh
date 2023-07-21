package com.vti.Controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Dto.ProductDto;
import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;
import com.vti.Service.IProductService;

@RestController
@RequestMapping(value = "api/v2/product")
@CrossOrigin("*")

public class ProductController {
	@Autowired
	private IProductService productService;

// Lấy all danh sách product

	@GetMapping()
	public ResponseEntity<?> getAllProduct(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Product> listProductPage = productService.getAllProduct(pageable, search);
//		List<ProductDto> productDtos = new ArrayList<>();
//
//		for (Product product : products) {
//			ProductDto productDto = new ProductDto();
//			productDto.setId(product.getId());
//			productDto.setName(product.getName().toString());
//			productDto.setPrice(product.getPrice());
//			productDto.setInfo(product.getInfo());
//			productDto.setDetail(product.getDetail());
//			productDto.setRatingStar(product.getRatingStar());
//			productDto.setImageName(product.getImageName());
//			productDto.setManufacturerName(product.getManufacturer().getName().toString());
//			productDto.setCategoryName(product.getCategory().getName());
//			productDtos.add(productDto);
//		}
		Page<ProductDto> productPageDtos = listProductPage.map(new Function<Product, ProductDto>() {

			@Override
			public ProductDto apply(Product product) {
				// TODO Auto-generated method stub
				ProductDto productDto = new ProductDto();
				productDto.setId(product.getId());
				productDto.setName(product.getName());
				productDto.setPrice(product.getPrice());
				productDto.setInfo(product.getInfo());
				productDto.setDetail(product.getDetail());
				productDto.setRatingStar(product.getRatingStar());
				productDto.setImageName(product.getImageName());
				productDto.setManufacturerName(product.getManufacturer().getName().toString());
				productDto.setCategoryName(product.getCategory().getName());
				return productDto;
			}
		});

		return new ResponseEntity<>(productPageDtos, HttpStatus.OK);

	}

	// Tìm Product theo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name = "id") short id) {
		try {
			Product product = productService.getProductById(id);
			// chuyển đổi dữ liệu
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			productDto.setInfo(product.getInfo());
			productDto.setDetail(product.getDetail());
			productDto.setRatingStar(product.getRatingStar());
			productDto.setImageName(product.getImageName());
			productDto.setManufacturerName(product.getManufacturer().getName().toString());
			productDto.setCategoryName(product.getCategory().getName());
			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		}

	}

// Thêm mới sản phẩm
	@PostMapping()
	public ResponseEntity<?> createProduct(@RequestBody ProductFormForCreating newProductForm) {
		try {
			Product newpProduct = productService.createProduct(newProductForm);
			// chuyển đổi dữ liệu
			ProductDto productDto = new ProductDto();
			productDto.setId(newpProduct.getId());
			productDto.setName(newpProduct.getName());
			productDto.setPrice(newpProduct.getPrice());
			productDto.setInfo(newpProduct.getInfo());
			productDto.setDetail(newpProduct.getDetail());
			productDto.setRatingStar(newpProduct.getRatingStar());
			productDto.setImageName(newpProduct.getImageName());
			productDto.setManufacturerName(newpProduct.getManufacturer().getName().toString());
			productDto.setCategoryName(newpProduct.getCategory().getName());

			return new ResponseEntity<>(productDto, HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Can't Create New Product", HttpStatus.BAD_REQUEST);
		}

	}

	// Update sản phẩm
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") short id,
			@RequestBody ProductFormForUpdating updateProductForm) {
		try {
			Product productUpdate = productService.updateProduct(id, updateProductForm);
			// Chuyển đổi dữ liệu
			ProductDto productDto = new ProductDto();
			productDto.setId(productUpdate.getId());
			productDto.setName(productUpdate.getName());
			productDto.setPrice(productUpdate.getPrice());
			productDto.setInfo(productUpdate.getInfo());
			productDto.setDetail(productUpdate.getDetail());
			productDto.setRatingStar(productUpdate.getRatingStar());
			productDto.setImageName(productUpdate.getImageName());
			productDto.setManufacturerName(productUpdate.getManufacturer().getName().toString());
			productDto.setCategoryName(productUpdate.getCategory().getName());

			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

	}

// Delete Product By ID
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable(name = "id") short id) {
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
			productDto.setCategoryName(deleteProduct.getCategory().getName());
// Thực hiện delete product
			productService.deleteProductById(id);
			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}
}

package com.vti.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;

public interface IProductService {

	public Page<Product> getAllProduct(Pageable pageable, String search);

	public Product getProductById(short id);

	public Product createProduct(ProductFormForCreating newProductForm);

	public Product updateProduct(short id, ProductFormForUpdating updateProductForm);

	public void deleteProductById(short id);

}

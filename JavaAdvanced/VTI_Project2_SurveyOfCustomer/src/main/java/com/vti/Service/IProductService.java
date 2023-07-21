package com.vti.Service;

import java.util.List;

import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;

public interface IProductService {

	List<Product> getAllproduct();

	Product getProductById(short id);

	Product creatNewProduct(ProductFormForCreating newProductForm);

	Product updateProduct(short id, ProductFormForUpdating updatingForm);

	void deleteProductById(short id);

}

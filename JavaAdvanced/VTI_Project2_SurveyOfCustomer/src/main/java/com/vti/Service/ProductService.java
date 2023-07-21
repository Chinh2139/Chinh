package com.vti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Entity.Manufacturer;
import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;
import com.vti.Repository.IManufacturerRepository;
import com.vti.Repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Override
	public List<Product> getAllproduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(short id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
	}

	@Override
	public Product creatNewProduct(ProductFormForCreating newProductForm) {
		// TODO Auto-generated method stub
		// Tìm manufacturer theo id
		Manufacturer manufacturer = manufacturerRepository.getById(newProductForm.getManufacturerId());
		Product product = new Product();
		product.setName(newProductForm.getName());
		product.setPrice(newProductForm.getPrice());
		product.setInfo(newProductForm.getInfo());
		product.setDetail(newProductForm.getDetail());
		product.setRatingStar(newProductForm.getRatingStar());
		product.setImageName(newProductForm.getImageName());
		product.setManufacturer(manufacturer);
		Product productNew = productRepository.save(product);
		return productNew;
	}

	@Override
	public Product updateProduct(short id, ProductFormForUpdating updatingForm) {
		Product product = productRepository.getById(id);
		// Tìm manufacturer theo id
		Manufacturer manufacturer = manufacturerRepository.getById(updatingForm.getManufacturerId());
		product.setName(updatingForm.getName());
		product.setPrice(updatingForm.getPrice());
		product.setInfo(updatingForm.getInfo());
		product.setDetail(updatingForm.getDetail());
		product.setRatingStar(updatingForm.getRatingStar());
		product.setImageName(updatingForm.getImageName());
		product.setManufacturer(manufacturer);
		Product productUpdate = productRepository.save(product);
		return productUpdate;

	}

	@Override
	public void deleteProductById(short id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}

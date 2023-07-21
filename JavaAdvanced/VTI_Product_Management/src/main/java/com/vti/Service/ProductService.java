package com.vti.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.Entity.Category;
import com.vti.Entity.Manufacturer;
import com.vti.Entity.Product;
import com.vti.Form.ProductFormForCreating;
import com.vti.Form.ProductFormForUpdating;
import com.vti.Repository.ICategoryRepository;
import com.vti.Repository.IManufacturerRepository;
import com.vti.Repository.IProductRepository;
import com.vti.specification.ProductSpecification;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Override
	public Product getProductById(short id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
	}

	@Override
	public Product createProduct(ProductFormForCreating newProductForm) {
		// TODO Auto-generated method stub

		// Tìm manufacturer theo id
		Manufacturer manufacturers = manufacturerRepository.getById(newProductForm.getManufacturerId());
		// Tìm Category theo id
		Category category = categoryRepository.getById(newProductForm.getCategoryId());
		Product product = new Product();
		product.setName(newProductForm.getName());
		product.setPrice(newProductForm.getPrice());
		product.setInfo(newProductForm.getInfo());
		product.setDetail(newProductForm.getDetail());
		product.setRatingStar(newProductForm.getRatingStar());
		product.setImageName(newProductForm.getImageName());
		product.setManufacturer(manufacturers);
		product.setCategory(category);
//		Product newpProduct = productRepository.save(product);
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(short id, ProductFormForUpdating updateProductForm) {
		// TODO Auto-generated method stub
		Product product = productRepository.getById(id);

		Manufacturer manufacturer = manufacturerRepository.getById(updateProductForm.getManufacturerId());
		Category category = categoryRepository.getById(updateProductForm.getCategoryId());
		product.setName(updateProductForm.getName());
		product.setPrice(updateProductForm.getPrice());
		product.setInfo(updateProductForm.getInfo());
		product.setDetail(updateProductForm.getDetail());
		product.setRatingStar(updateProductForm.getRatingStar());
		product.setImageName(updateProductForm.getImageName());
		product.setManufacturer(manufacturer);
		product.setCategory(category);

		Product productUpdate = productRepository.save(product);
		return productUpdate;

	}

	@Override
	public void deleteProductById(short id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Page<Product> getAllProduct(Pageable pageable, String search) {
		// TODO Auto-generated method stub
		Specification<Product> where = null;
		if (!StringUtils.isEmpty(search)) {
			ProductSpecification nameSpecification = new ProductSpecification("name", "LIKE", search);
			ProductSpecification priceSpecification = new ProductSpecification("price", "LIKE", search);
			ProductSpecification infoSpecification = new ProductSpecification("info", "LIKE", search);
			ProductSpecification categorySpecification = new ProductSpecification("category", "LIKE", search);

			where = Specification.where(nameSpecification).or(priceSpecification).or(infoSpecification)
					.or(categorySpecification);
		}

		return productRepository.findAll(where, pageable);

	}

}

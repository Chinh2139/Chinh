package com.vti.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ManufacturerTV", catalog = "SurveyOfCustomer")
public class Manufacturer implements Serializable {

	@Column(name = "ManufacturerId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "ManufacturerName", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private ManufacturerName name;

	@OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
	private List<Product> product;

	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public ManufacturerName getName() {
		return name;
	}

	public void setName(ManufacturerName name) {
		this.name = name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}

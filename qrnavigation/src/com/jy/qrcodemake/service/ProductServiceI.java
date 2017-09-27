package com.jy.qrcodemake.service;

import java.util.List;

import com.jy.qrcodemake.entity.Product;



public interface ProductServiceI {
	public int countProduct();
	public void createProduct(Product product);
	public void deleteProduct(Product product) throws Exception;
	public Product loadProduct(String id) throws Exception;
	public void updateProduct(Product product);
	public Product findProductById(String id);
	public List<Product> listProduct();
}

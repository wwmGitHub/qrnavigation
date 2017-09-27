package com.jy.qrcodemake.service.impl;

import java.util.HashMap;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.qrcodemake.dao.CdcDao;
import com.jy.qrcodemake.entity.Product;
import com.jy.qrcodemake.service.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI{
	private CdcDao cdcDao;
	@Autowired
	public ProductServiceImpl(CdcDao cdcDao)
	{
		this.cdcDao = cdcDao;
	}
	
	public int countProduct() {
		return cdcDao.hqlCountWithParams(
				"select count(sa.qrcode_id) from Product sa", new HashMap());
	}
	
	public void createProduct(Product UieasyMenu) {
		cdcDao.createModel(UieasyMenu);	
		
	}
	
	public void deleteProduct(Product UieasyMenu) throws Exception {
		// TODO Auto-generated method stub
		cdcDao.deleteModel(UieasyMenu);
	}
	


	
	public List<Product> listProduct(){
		List<Product> list = cdcDao.hqlQueryWithParams("From Product ",
				new HashMap());
		return list;
	}
	
	public Product loadProduct(String projectId) {
		if (projectId!=null){
		Product project = (Product) cdcDao.loadModel(
				Product.class, projectId);
		Hibernate.initialize(project);
		
		return project;
		}else {
			//查询二维码级联查询出对应账号数据

		}
		return  null;
	}
	
	public void updateProduct(Product s) {
		// TODO Auto-generated method stub
		cdcDao.updateModel(s);
	}
	
	public Product findProductById(String projectId) {
		List<Product> list = cdcDao.hqlQueryWithParams(" from Product where  qrcode_id = '"+projectId+"' ", new HashMap());
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}		
	}

	


}

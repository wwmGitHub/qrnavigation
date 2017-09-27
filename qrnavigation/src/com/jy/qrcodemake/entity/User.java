package com.jy.qrcodemake.entity;

import javax.persistence.*;


@Entity
@Table(name = "user", catalog = "qrcodemake")
public class User implements java.io.Serializable {
	// Fields
	private String userId;
	private String userLoginName;
	private String userLoginPass;
	private Product product;
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public User(String userId, String userLoginName, String userLoginPass
			) {
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userLoginPass = userLoginPass;
		
	}

	// Property accessors
	//@GeneratedValue(strategy=GenerationType.AUTO) id生成策略相当于hibernate中的native

	@Id
	@GeneratedValue//主键id自动生成 相当于[配置中的主键生成策略]
	@Column(name = "user_id", unique = true, nullable = false, length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_login_name")
	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	@Column(name = "user_login_pass")
	public String getUserLoginPass() {
		return this.userLoginPass;
	}

	public void setUserLoginPass(String userLoginPass) {
		this.userLoginPass = userLoginPass;
	}

	/**
	 *配置关联关系
	 * @return
     */
	/*
	@ManyToOne           //多的一端加入关联关键 ，
    @JoinColumn(name="classesid")  关联对象的主键
    public Classes getClasses() {  关联对象
        return classes;
    }
    public void setClasses(Classes classes) {
        this.classes = classes;
    }
	* */
	@OneToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}

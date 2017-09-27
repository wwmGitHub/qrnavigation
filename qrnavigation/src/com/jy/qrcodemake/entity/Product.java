package com.jy.qrcodemake.entity;
// default package

import javax.persistence.*;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "qrcodemake")

public class Product implements java.io.Serializable {

	// Fields

	private String qrcodeId;
	private String scenicspotName;
	private String scenicspotBg;
	private String scenicspotWav;
	private String scenicspotLink;
	private String qrcodeParam;
	private String scenicspotLinkContent;
	private User user;

	@OneToOne(mappedBy="product",targetEntity = User.class)
	@JoinColumn(name = "product_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String qrcodeId, String scenicspotName) {
		this.qrcodeId = qrcodeId;
		this.scenicspotName = scenicspotName;
	}

	/** full constructor */
	public Product(String qrcodeId, String scenicspotName, String scenicspotBg, String scenicspotWav,
			String scenicspotLink, String qrcodeParam, String scenicspotLinkContent) {
		this.qrcodeId = qrcodeId;
		this.scenicspotName = scenicspotName;
		this.scenicspotBg = scenicspotBg;
		this.scenicspotWav = scenicspotWav;
		this.scenicspotLink = scenicspotLink;
		this.qrcodeParam = qrcodeParam;
		this.scenicspotLinkContent = scenicspotLinkContent;
	}

	// Property accessors
	@Id

	@Column(name = "qrcode_id", unique = true, nullable = false, length = 32)

	public String getQrcodeId() {
		return this.qrcodeId;
	}

	public void setQrcodeId(String qrcodeId) {
		this.qrcodeId = qrcodeId;
	}

	@Column(name = "scenicspot_name", nullable = false)

	public String getScenicspotName() {
		return this.scenicspotName;
	}

	public void setScenicspotName(String scenicspotName) {
		this.scenicspotName = scenicspotName;
	}

	@Column(name = "scenicspot_bg")

	public String getScenicspotBg() {
		return this.scenicspotBg;
	}

	public void setScenicspotBg(String scenicspotBg) {
		this.scenicspotBg = scenicspotBg;
	}

	@Column(name = "scenicspot_wav")

	public String getScenicspotWav() {
		return this.scenicspotWav;
	}

	public void setScenicspotWav(String scenicspotWav) {
		this.scenicspotWav = scenicspotWav;
	}

	@Column(name = "scenicspot_link")

	public String getScenicspotLink() {
		return this.scenicspotLink;
	}

	public void setScenicspotLink(String scenicspotLink) {
		this.scenicspotLink = scenicspotLink;
	}

	@Column(name = "qrcode_param", length = 2000)

	public String getQrcodeParam() {
		return this.qrcodeParam;
	}

	public void setQrcodeParam(String qrcodeParam) {
		this.qrcodeParam = qrcodeParam;
	}

	@Column(name = "scenicspot_link_content", length = 4000)

	public String getScenicspotLinkContent() {
		return this.scenicspotLinkContent;
	}

	public void setScenicspotLinkContent(String scenicspotLinkContent) {
		this.scenicspotLinkContent = scenicspotLinkContent;
	}




}
/**
 * Copyright (C) 2012, Xieda Technology, Inc.
 */
package com.jy.qrcodemake.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jy.qrcodemake.util.ActionTypeEnum;
import com.jy.qrcodemake.util.Constants;

/**
 * Simple JavaBean domain object representing a <code>History</code> record.
 * 
 * @author frank
 * @since 04.05.2012
 */
@Entity
@Table(name = "log")
public class Log {
	
	private Integer id;
	
	/** Username of the current operator. */
	private String user;
	
	/** The time when current history record is created. */
	private Date createdTime;

	/** 
	 * The type of an operation. For example: "ADD", "EDIT".
	 * It is String, not an instance of ActionTypeEnum. 
	 */
	private String actionType;
	
	/** The name of an item. For example: "CDC".*/
	private String itemName;

	/** The value of an item. */
	private String itemValue;

	/** The type of an item. For example: "Z", "U", "RR". */
	private String itemType;

	/** Default constructor. */
	public Log() {
		super();
	}


	/**
	 * Creates a new instance of History for the action of a UserVO with given parameters.
	 * 
	 * @param user
	 *            contains values we need
	 * @param actionType
	 *            it's just actionType
	 */
//	public Log(UserVO user, ActionTypeEnum actionType) {
//		// Get the current logged-in user.
//		UserVO currentUser = SecurityUser.getCurrentUser();
//		if (currentUser != null)
//			this.user = currentUser.getName();
//		else
//			this.user = "jmcdc";
//		
//		this.createdTime = new Date();
//		this.actionType = actionType.name();
//		this.itemName = user.getName();
//		this.itemType = Constants.LOG_ITEMTYPE_USER;
////		this.itemValue = user.getRole().getName();
//	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the user.
	 */
	@Column(name = "log_user", length = 255)
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the createdTime.
	 */
	@Column(name = "created_time", length = 255)
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the actionType.
	 */
	@Column(name = "log_type", length = 255)
	public String getActionType() {
		return actionType;
	}

	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return the itemName.
	 */
	@Column(name = "item_name", length = 255)
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemValue.
	 */
	@Column(name = "item_value", length = 255)
	public String getItemValue() {
		return itemValue;
	}

	/**
	 * @param itemValue the itemValue to set
	 */
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	/**
	 * @return the itemType.
	 */
	@Column(name = "item_type", length = 255)
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * Get the string of a history record which displays on the page.
	 * 
	 * Samples: 
	 * 1, (2012-04-07 11:43:21.0) frank ADD cdc jmcdc.
	 * 2, (2012-04-07 15:36:01.0) frank made user hunter an admin
	 */
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("(");

		value.append(this.getCreatedTime().toString().substring(0, 19))
			 .append(") ")
			 .append(this.getUser());

		// Handle a CDC.
		if (this.getItemType().equals(Constants.LOG_ITEMTYPE_CDC) ) {
			value.append(" ");
			if (this.getActionType().equals(ActionTypeEnum.ADD.name())) value.append("added");
			if (this.getActionType().equals(ActionTypeEnum.EDIT.name())) value.append("edited");
			if (this.getActionType().equals(ActionTypeEnum.DELETE.name())) value.append("deleted");
				value.append(" ")
					 .append(this.getItemName());
			
		} else {// Handle a user
			if (this.getActionType().equals(ActionTypeEnum.ADD.name())) {

				value.append(" added user: ").append(this.getItemName());
			}
			if (this.getActionType().equals(ActionTypeEnum.DELETE.name())) {

				value.append(" deleted user: ").append(this.getItemName());

			}
			if (this.getActionType().equals(
					ActionTypeEnum.CHANGEPASSWORD.name())) {

				value.append(" changed password for user: ").append(
						this.getItemName());

			}
			if (this.getActionType().equals(ActionTypeEnum.CHANGEROLE.name())) {
				if (this.getItemValue().equals(Constants.LOG_ROLE_USER)) {

					value.append(" removed admin status from ").append(
							this.getItemName());

				}
				if (this.getItemValue().equals(Constants.LOG_ROLE_ADMIN)) {

					value.append(" made user ")
						 .append(this.getItemName())
						 .append(" an admin");

				}
				if (this.getItemValue().equals(Constants.LOG_ROLE_CSR)) {

					value.append(" removed CSR admin status from ").append(
							this.getItemName());
				}
				if (this.getItemValue().equals(Constants.LOG_ROLE_CSRADMIN)) {

					value.append(" made user ")
						 .append(this.getItemName())
						 .append(" an CSR admin");

				}
			}
		}
		return value.toString();
	}

	/** This getter is used to show history records on history page. */
	/*public String getHistoryString() {
		return toString();
	}*/
}

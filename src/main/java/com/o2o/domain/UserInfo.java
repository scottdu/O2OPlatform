package com.o2o.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_info database table.
 * 
 */
@Entity
@Table(name="user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="account_icon")
	private String accountIcon = "";

	@Column(name="biz_desc")
	private String bizDesc = "";

	@Column(name="biz_permit_photo")
	private String bizPermitPhoto = "";

	@Column(name="change_unit")
	private String changeUnit = "";

	private String city = "";

	private String country = "";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	private String currency = "";

	@Column(name="fix_phone")
	private String fixPhone = "";

	@Column(name="id_no")
	private String idNo = "";

	@Column(name="id_photo")
	private String idPhoto = "";

	@Column(name="id_type")
	private String idType = "";

	private String nationality = "";

	private String province = "";

	private String street = "";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	@Column(name="user_id")
	private int userId;

	@Column(name="work_address")
	private String workAddress = "";

	public UserInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountIcon() {
		return this.accountIcon;
	}

	public void setAccountIcon(String accountIcon) {
		this.accountIcon = accountIcon;
	}

	public String getBizDesc() {
		return this.bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}

	public String getBizPermitPhoto() {
		return this.bizPermitPhoto;
	}

	public void setBizPermitPhoto(String bizPermitPhoto) {
		this.bizPermitPhoto = bizPermitPhoto;
	}

	public String getChangeUnit() {
		return this.changeUnit;
	}

	public void setChangeUnit(String changeUnit) {
		this.changeUnit = changeUnit;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFixPhone() {
		return this.fixPhone;
	}

	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

}
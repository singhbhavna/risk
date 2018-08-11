package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.criterion.Restrictions;
import org.primefaces.model.UploadedFile;

import com.psas.common.HibernateUtil;

@Entity
@Table(name = "Bank1", uniqueConstraints = @UniqueConstraint(columnNames = "shortname"))

public class Bank1 implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721925895649530896L;
	
	
	private int id;
	private String organizationId;
	private String parentorgId;
    private String organizationdescription;
	private String shortname;
	private String website;
	private String telephone;
	private String fax;
	private String organizationtype;
	
	
	public Bank1(int id) {
		this.id = id;
	}
	
	public Bank1() {
		
	}
	


	
	public Bank1(int id, String organizationId, String parentorgId, String shortname, String organizationdescription,
			String shortname2, String website, String telephone, String fax, String organizationtype, byte[] file) {
		super();
		this.id = id;
		this.organizationId = organizationId;
		this.parentorgId = parentorgId;
		
		this.organizationdescription = organizationdescription;
		shortname = shortname;
		this.website = website;
		this.telephone = telephone;
		this.fax = fax;
		this.organizationtype = organizationtype;
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "organizationId", length = 100)
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	@Column(name = "parentorgId", length = 100)
	public String getParentorgId() {
		return parentorgId;
	}

	public void setParentorgId(String parentorgId) {
		this.parentorgId = parentorgId;
	}
	
	@Column(name = "organizationdescription", length = 100)
	public String getOrganizationdescription() {
		return organizationdescription;
	}

	public void setOrganizationdescription(String organizationdescription) {
		this.organizationdescription = organizationdescription;
	}
	@Column(name = "shortname", length = 100)
	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	@Column(name = "website", length = 100)
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	@Column(name = "telephone", length = 100)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name = "fax", length = 100)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name = "organizationtype", length = 100)
	public String getOrganizationtype() {
		return organizationtype;
	}

	public void setOrganizationtype(String organizationtype) {
		this.organizationtype = organizationtype;
	}
	

	

	
}
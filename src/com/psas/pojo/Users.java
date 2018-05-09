package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Users implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133395100284433443L;

	private int id;
	private String name;
	private String address;
	private String phone;
	
	
	public Users(int id) {
		this.id = id;
	}
	
	

	public Users(int id, String name, String address, String phone) {
	
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public Users() {
		// TODO Auto-generated constructor stub
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
	
	@Column(name = "name", unique = true, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Address", length = 100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "phone", length = 12)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}

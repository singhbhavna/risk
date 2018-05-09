package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))

public class Role implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721925895649530896L;
	
	
	private int id;
	private String Rolename;
	private Boolean status;
	
	
	public Role(int id) {
		this.id = id;
	}
	
	public Role() {
		
	}



	public Role(int id, String name, Boolean status) {
		super();
		this.id = id;
		this.Rolename = name;
		this.status = status;
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
	@Column(name = "Rolename", length = 100)
	public String getRolename() {
		return Rolename;
	}

	public void setRolename(String rolename) {
		Rolename = rolename;
	}
	@Column(name = "status",  length = 100)
	public Boolean getStatus() {
		return status;
	}
	

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	
	

}


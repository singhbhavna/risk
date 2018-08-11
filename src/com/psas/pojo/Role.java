package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "rolename"))

public class Role implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721925895649530896L;
	
	
	private int id;
	private String rolename;
	private Boolean status;
	
	private byte[] attachment;
	
	public Role(int id) {
		this.id = id;
	}
	
	public Role() {
		
	}


	
	public Role(int id, String rolename, Boolean status,byte[] attachment) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.status = status;
		this.attachment = attachment;
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
	@Column(name = "rolename", length = 100)
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	@Column(name = "status",  length = 100)
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "attachment",  length = 100)
	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
	
	
	
	

}


package com.psas.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.psas.dao.RegisterInterface;
import com.psas.daoimpl.RegisterImpl;



@ManagedBean(name = "register", eager = true)
@RequestScoped
public class Register implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490931270874523601L;
	private String name;
	private String address;
	private String phone;
	
	private RegisterInterface registerInterface = new RegisterImpl();
	
	public String submit(){
		
		int result = 0;
		try{
			
			result=	registerInterface.saveusers(name,address,phone);
			
			 
			if(result==2){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"User Exits",
								"Please check and try again"));
				return "register";
				
			}

			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Internal Error",
							"Please check the server logs"));
		}
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
	
	
	

}

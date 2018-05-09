package com.psas.beans;


	import java.util.ArrayList;
	import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.RequestScoped;
	import javax.faces.context.FacesContext;


import com.psas.dao.RoleInterface;
import com.psas.daoimpl.RoleImpl;

import com.psas.vo.MasterVo;



	

@ManagedBean(name = "rolebean", eager = true)
@RequestScoped

	
public class Rolebean {
	private String rolename;
private RoleInterface hg=new RoleImpl();
	
private  List<MasterVo> masterList=new ArrayList<MasterVo>();


@PostConstruct
public void init(){
	masterList = new  ArrayList<MasterVo>();
	
	try {
		masterList = hg.getretrive();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	



public String submit(){
	int result=0;
	
	try {
		result=hg.getsaverole(rolename);
		
		
		if(result == 1)
		{
			
			masterList = hg.getretrive();
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Role created  successfully.",
							"Role created  successfully."));
		}
		
		
		if(result==2){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"enter users",
							"Please check and try again"));
			return "Rolemaster";
		}
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "Rolemaster";
	}
	
	
	
	return "Rolemaster";
	
	
	
}





public String getRolename() {
	return rolename;
}





public void setRolename(String rolename) {
	this.rolename = rolename;
}





public List<MasterVo> getMasterList() {
	return masterList;
}





public void setMasterList(List<MasterVo> masterList) {
	this.masterList = masterList;
}






	

	
	


	
	
}
	
	



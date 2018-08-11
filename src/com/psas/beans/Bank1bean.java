package com.psas.beans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.model.UploadedFile;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.psas.dao.Bank2Interface;
import com.psas.daoimpl.BankImpl;
import com.psas.vo.BankVo;



@ManagedBean(name = "bank1bean", eager = true)
@RequestScoped
@ViewScoped
	
public class Bank1bean {
	private int id;
	private String organizationId;
	private String parentorgId;
    private String organizationdescription;
	private String shortname;
	private String website;
	private String telephone;
	private String fax;
	private String organizationtype;
	
	
	
	
private Bank2Interface bj=new BankImpl();
	
private  List<BankVo> bankList=new ArrayList<BankVo>();

BankVo bankVo = new BankVo();
@PostConstruct
public void init(){
	bankList = new  ArrayList<BankVo>();
	
	try {
		bankList = bj.getstart1();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	



public String submit(){
	int result=0;
	
	try {
		result=bj.getstart(organizationId,shortname, parentorgId,organizationdescription,website, telephone,fax,organizationtype);
		
		
		if(result == 1)
		{
			
			
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Risk Bank created  successfully.",
							"Risk Bank created  successfully."));
		}
		
		
		if(result==2){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"enter users",
							"Please check and try again"));
			return "keyinformation";
		}
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "keyinformation";
	}
	
	
	
	return "keyinformation";
	
	
	
}





public void postProcessXLS(Object document) {
    HSSFWorkbook wb = (HSSFWorkbook) document;
    HSSFSheet sheet = wb.getSheetAt(0);
    HSSFRow header = sheet.getRow(0);
     
    HSSFCellStyle cellStyle = wb.createCellStyle();  
    cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
     
    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
        HSSFCell cell = header.getCell(i);
         
        cell.setCellStyle(cellStyle);
    }
    
    
 }
 
public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
    Document pdf = (Document) document;
    pdf.open();
    pdf.setPageSize(PageSize.A4);

    //ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    //String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";
     
    pdf.addTitle("Collabor8");
}








public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}







public String getOrganizationId() {
	return organizationId;
}





public void setOrganizationId(String organizationId) {
	this.organizationId = organizationId;
}





public String getParentorgId() {
	return parentorgId;
}





public void setParentorgId(String parentorgId) {
	this.parentorgId = parentorgId;
}










public String getOrganizationdescription() {
	return organizationdescription;
}





public void setOrganizationdescription(String organizationdescription) {
	this.organizationdescription = organizationdescription;
}





public String getShortname() {
	return shortname;
}





public void setShortname(String shortname) {
	this.shortname = shortname;
}





public String getWebsite() {
	return website;
}





public void setWebsite(String website) {
	this.website = website;
}





public String getTelephone() {
	return telephone;
}





public void setTelephone(String telephone) {
	this.telephone = telephone;
}





public String getFax() {
	return fax;
}





public void setFax(String fax) {
	this.fax = fax;
}





public String getOrganizationtype() {
	return organizationtype;
}





public void setOrganizationtype(String organizationtype) {
	this.organizationtype = organizationtype;
}





public List<BankVo> getBankList() {
	return bankList;
}





public void setBankList(List<BankVo> bankList) {
	this.bankList = bankList;
}







public void setBankVo(BankVo bankVo) {
	this.bankVo = bankVo;
}















	

	
	


	
	
}
	
	



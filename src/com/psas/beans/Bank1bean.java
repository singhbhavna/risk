package com.psas.beans;


	import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.RequestScoped;
	import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.psas.dao.Bank2Interface;
import com.psas.daoimpl.BankImpl;

import com.psas.vo.BankVo;
@ManagedBean(name = "bank1bean", eager = true)
@RequestScoped

	
public class Bank1bean {
	private int id;
	private String BankRisk;
	private String Risktitle;
	private String Riskdescription;
	private String Source;
	private String Function;
	private String Industry;
	private String Section;
	private String Background;
	private String Remarks;
	private String Notes;
	private String Status; 
private Bank2Interface bj=new BankImpl();
	
private  List<BankVo> bankList=new ArrayList<BankVo>();


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
		result=bj.getstart(BankRisk,Risktitle,Riskdescription,Source,Function,Industry,Section,Background,Remarks,Notes,Status);
		
		
		if(result == 1)
		{
			
			
			
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
			return "Riskbank";
		}
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "Riskbank";
	}
	
	
	
	return "Riskbank";
	
	
	
}








public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}





public String getBankRisk() {
	return BankRisk;
}





public void setBankRisk(String bankRisk) {
	BankRisk = bankRisk;
}





public String getRisktitle() {
	return Risktitle;
}





public void setRisktitle(String risktitle) {
	Risktitle = risktitle;
}





public String getRiskdescription() {
	return Riskdescription;
}





public void setRiskdescription(String riskdescription) {
	Riskdescription = riskdescription;
}





public String getSource() {
	return Source;
}





public void setSource(String source) {
	Source = source;
}





public String getFunction() {
	return Function;
}





public void setFunction(String function) {
	Function = function;
}





public String getIndustry() {
	return Industry;
}





public void setIndustry(String industry) {
	Industry = industry;
}





public String getSection() {
	return Section;
}





public void setSection(String section) {
	Section = section;
}





public String getBackground() {
	return Background;
}





public void setBackground(String background) {
	Background = background;
}





public String getRemarks() {
	return Remarks;
}





public void setRemarks(String remarks) {
	Remarks = remarks;
}





public String getNotes() {
	return Notes;
}





public void setNotes(String notes) {
	Notes = notes;
}





public String getStatus() {
	return Status;
}





public void setStatus(String status) {
	Status = status;
}





public List<BankVo> getBankList() {
	return bankList;
}





public void setBankList(List<BankVo> bankList) {
	this.bankList = bankList;
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

    
    pdf.addTitle("Collabor8");
}











	

	
	


	
	
}
	
	



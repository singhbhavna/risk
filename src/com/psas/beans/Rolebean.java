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
import com.psas.dao.RoleInterface;
import com.psas.daoimpl.RoleImpl;

import com.psas.vo.MasterVo;



	

@ManagedBean(name = "rolebean", eager = true)
@RequestScoped
@ViewScoped
	
public class Rolebean {
	private String rolename;
	private Integer id;
	 private UploadedFile attachment;
private RoleInterface hg=new RoleImpl();
	
private  List<MasterVo> masterList=new ArrayList<MasterVo>();

MasterVo  masterVo = new MasterVo();
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
		result=hg.getsaverole(rolename,attachment);
		
		
		if(result == 1)
		{
			
			masterList = hg.getretrive();
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Role created  successfully.",
							"Role created  successfully."));
		}
		
		
		if(result==2){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
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
public void modifyAction(){

    try
    {
    	masterVo = new MasterVo();
    	setId(id);
    	
    	 masterVo = hg.getretrivedata(id);
    	
    	FacesContext.getCurrentInstance()
        .getExternalContext().dispatch("updaterole.xhtml");

    }
    catch(Exception e){
    	e.printStackTrace();
    }
    
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










public Integer getId() {
	return id;
}





public void setId(Integer id) {
	this.id = id;
}





public UploadedFile getAttachment() {
	return attachment;
}





public void setAttachment(UploadedFile attachment) {
	this.attachment = attachment;
}





public MasterVo getMasterVo() {
	return masterVo;
}





public void setMasterVo(MasterVo masterVo) {
	this.masterVo = masterVo;
}







	

	
	


	
	
}
	
	



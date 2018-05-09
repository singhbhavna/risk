package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Bank1", uniqueConstraints = @UniqueConstraint(columnNames = "Bankrisk"))

public class Bank1 implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721925895649530896L;
	
	
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
	private Boolean status;
	
	
	public Bank1(int id) {
		this.id = id;
	}
	
	public Bank1() {
		
	}


	

	public Bank1(int id, String bankRisk, String risktitle, String riskdescription, String source, String function,
			String industry, String section, String background, String remarks, String notes, Boolean status) {
		super();
		this.id = id;
		BankRisk = bankRisk;
		Risktitle = risktitle;
		Riskdescription = riskdescription;
		Source = source;
		Function = function;
		Industry = industry;
		Section = section;
		Background = background;
		Remarks = remarks;
		Notes = notes;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id2) {
		this.id = id2;
	}
	@Column(name = "BankRisk",  length = 100)
	public String getBankRisk() {
		return BankRisk;
	}

	public void setBankRisk(String bankRisk) {
		BankRisk = bankRisk;
	}
	@Column(name = "Risktitle",  length = 100)
	public String getRisktitle() {
		return Risktitle;
	}

	public void setRisktitle(String risktitle) {
		Risktitle = risktitle;
	}
	@Column(name = "Riskdescription",  length = 100)
	public String getRiskdescription() {
		return Riskdescription;
	}

	public void setRiskdescription(String riskdescription) {
		Riskdescription = riskdescription;
	}
	@Column(name = "Source",  length = 100)
	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}
	@Column(name = "Function",  length = 100)
	public String getFunction() {
		return Function;
	}

	public void setFunction(String function) {
		Function = function;
	}
	@Column(name = "Industry",  length = 100)
	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}
	@Column(name = "Section",  length = 100)
	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}
	@Column(name = "Background",  length = 100)
	public String getBackground() {
		return Background;
	}

	public void setBackground(String background) {
		Background = background;
	}
	@Column(name = "Remarks",  length = 100)
	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	@Column(name = "Notes",  length = 100)
	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}
	@Column(name = "Status",  length = 100)
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	
	
	

	
	
	

	
}

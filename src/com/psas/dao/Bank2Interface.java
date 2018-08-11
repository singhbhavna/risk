package com.psas.dao;

import java.util.List;

import org.primefaces.model.UploadedFile;

import com.psas.vo.BankVo;

public interface Bank2Interface {

	
  



public int getstart(String organizationId, String shortname, String parentorgId, String organizationdescription,
		String website, String telephone, String fax, String organizationtype)throws Exception;
List<BankVo> getstart1()throws Exception;

}

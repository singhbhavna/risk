package com.psas.dao;

import java.util.List;

import com.psas.vo.BankVo;

public interface Bank2Interface {

	
	int getstart(String bankRisk, String risktitle, String riskdescription, String source, String function,
			String industry, String section, String background, String remarks, String notes, String status) throws Exception;
   List<BankVo> getstart1()throws Exception;


;
}


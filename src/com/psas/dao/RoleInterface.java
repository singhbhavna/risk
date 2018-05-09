package com.psas.dao;

import java.util.List;

import javax.management.relation.RoleList;

import com.psas.vo.MasterVo;

public interface RoleInterface {

	int getsaverole(String rolename) throws Exception;

	List<MasterVo> getretrive()throws Exception;;

	
}


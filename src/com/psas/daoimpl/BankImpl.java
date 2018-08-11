package com.psas.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.primefaces.extensions.component.masterdetail.MasterDetail;
import org.primefaces.model.UploadedFile;

import com.psas.common.HibernateUtil;
import com.psas.common.HibernateUtil;
import com.psas.dao.Bank2Interface;

import com.psas.pojo.Bank1;
import com.psas.pojo.Users;
import com.psas.vo.BankVo;


public class BankImpl implements Bank2Interface {


	@Override
	public int getstart(String organizationId, String shortname, String parentorgId, String organizationdescription,
			String website, String telephone, String fax, String organizationtype) throws Exception {		
		// TODO Auto-generated method stub
		
		Bank1 BankTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		
		try{
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
				
			BankTemp =  (Bank1) session.createCriteria(Bank1.class)
					.add(Restrictions.eq("shortname",shortname))				
					
					.uniqueResult();
			
			if (BankTemp != null) {

				result=2;	
			}else{
				
				BankTemp = new Bank1();
				
				
				BankTemp.setOrganizationdescription(organizationdescription);
				BankTemp.setOrganizationId(organizationId);
				BankTemp.setOrganizationtype(organizationtype);
				BankTemp.setParentorgId(parentorgId);
				BankTemp.setFax(fax);
				BankTemp.setShortname(shortname);
				BankTemp.setTelephone(telephone);
				BankTemp.setWebsite(website);

				
				session.save(BankTemp);
				
			
			result=1;
			}
			
				tx.commit();
			
			
			
			
			
		}catch(Exception e){
			if(tx != null)
			{
				tx.rollback();
			}

			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (session != null)
				session.close();
		}
		
		
		return result;
	
	}
	
	
	

	

	@SuppressWarnings("unchecked")
	@Override
	public List<BankVo> getstart1() throws Exception {
		// TODO Auto-generated method stub
		List<BankVo> BankList = new ArrayList<BankVo>();
		
		Bank1 Bank1Temp = null;
		Session session = null;
		Transaction tx = null;
		BankVo BankVo=null;
		try
		{
			session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            
			List<Bank1> getBankList = (List<Bank1>) session
					.createCriteria(Bank1.class)					
					.list();
           
			for(Bank1 Bank1DB :getBankList){
			
			
				BankVo= new BankVo();
			
					
				BankVo.setId(Bank1DB.getId());
				BankVo.setOrganizationId(Bank1DB.getOrganizationId());
				BankVo.setParentorgId(Bank1DB.getParentorgId());
				BankVo.setOrganizationtype(Bank1DB.getOrganizationtype());
				BankVo.setshortname(Bank1DB.getShortname());
				BankVo.setOrganizationdescription(Bank1DB.getOrganizationdescription());
				BankVo.setWebsite(Bank1DB.getWebsite());
				BankVo.setTelephone(Bank1DB.getTelephone());
				BankVo.setFax(Bank1DB.getFax());
			
			
			
			BankList.add(BankVo);
			
			
		
			
			}
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
        	if(session != null)
            session.close();
	    }

		return BankList;
	}






	


	






}

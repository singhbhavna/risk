package com.psas.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.primefaces.extensions.component.masterdetail.MasterDetail;

import com.psas.common.HibernateUtil;
import com.psas.dao.Bank2Interface;

import com.psas.pojo.Bank1;
import com.psas.pojo.Users;
import com.psas.vo.BankVo;


public class BankImpl implements Bank2Interface {

	



	@Override
	public int getstart(String Bankrisk, String risktitle, String riskdescription, String source, String function, String industry, String section, String background, String remarks, String notes, String status) throws Exception {		
		// TODO Auto-generated method stub
		
		Bank1 BankTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		
		try{
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			BankTemp =  (Bank1) session.createCriteria(Bank1.class)
					.add(Restrictions.eq("risktitle",risktitle.toLowerCase().trim()).ignoreCase())				
					
					.uniqueResult();
			
			if (BankTemp != null) {

				result=2;	
			}else{
				
				BankTemp = new Bank1();
				
				
				BankTemp.setStatus(true);
				BankTemp.setBackground(background);
		        BankTemp.setFunction(function);
				BankTemp.setRemarks(remarks);
				BankTemp.setRiskdescription(riskdescription);
				BankTemp.setRisktitle(risktitle);
	            BankTemp.setNotes(notes);
				BankTemp.setIndustry(industry);
				BankTemp.setSection(section);
				BankTemp.setSource(source);
				
				
				
				
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
		
            
			@SuppressWarnings("unchecked")
			List<Bank1> getBankList = (List<Bank1>) session
					.createCriteria(Bank1.class)					
					.list();
           
			for(Bank1 Bank1DB :getBankList){
			
			
				BankVo= new BankVo();
			
					
				
		    	
		    	BankVo.setNotes(Bank1DB.getNotes());
		    	BankVo.setBackground(Bank1DB.getBackground());
		    	BankVo.setRemarks(Bank1DB.getRemarks());
		    	BankVo.setRiskdescription(Bank1DB.getRiskdescription());
		        BankVo.setRisktitle(Bank1DB.getRisktitle());
		        BankVo.setFunction(Bank1DB.getFunction());
		        BankVo.setIndustry(Bank1DB.getIndustry());
		        BankVo.setSource(Bank1DB.getSource());
		        BankVo.setSection(Bank1DB.getSection());
		        
		        if(Bank1DB.getStatus().equals(true)){
		        	BankVo.setStatus("Active");
		        }else{
		        	BankVo.setStatus("Active");
		        }
		        
			
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

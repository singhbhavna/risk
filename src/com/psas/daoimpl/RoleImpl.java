package com.psas.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.primefaces.model.UploadedFile;

import com.psas.beans.Rolebean;
import com.psas.common.HibernateUtil;
import com.psas.dao.RoleInterface;
import com.psas.pojo.Role;

import com.psas.vo.MasterVo;


public class RoleImpl implements RoleInterface {

	



	@Override
	public int getsaverole(String rolename,UploadedFile attachment) throws Exception {		
		// TODO Auto-generated method stub
		
		Role roleTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		
		try{
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			roleTemp =  (Role) session.createCriteria(Role.class)
					.add(Restrictions.eq("rolename",rolename.toLowerCase().trim()).ignoreCase())				
					
					.uniqueResult();
			
			if (roleTemp != null) {

				result=2;	
			}else{
				
				roleTemp = new Role();
				
				roleTemp.setRolename(rolename);
				roleTemp.setStatus(true);
			//	roleTemp.setAttachment(attachment.getContents());
				
				session.save(roleTemp);
				
			
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
	public List<MasterVo> getretrive() throws Exception {
		// TODO Auto-generated method stub
		List<MasterVo> roleList = new ArrayList<MasterVo>();
		@SuppressWarnings("unused")
		Role roleTemp = null;
		Session session = null;
		Transaction tx = null;
		MasterVo masterVo=null;
		try
		{
           	session = HibernateUtil.getSession();
            tx = session.beginTransaction();
		
            
			@SuppressWarnings("unchecked")
			List<Role> getRoleList = (List<Role>) session
					.createCriteria(Role.class)					
					.list();
           
			for(Role roleDB :getRoleList){
			
			
				masterVo= new MasterVo();
				masterVo.setId(roleDB.getId());
					
				masterVo.setRolename(roleDB.getRolename());
				masterVo.setStatus(roleDB.getStatus());
			
			
			roleList.add(masterVo);
			
			
		
			
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

		return roleList;
	}






	@Override
	public MasterVo getretrivedata(int id) throws Exception  {
		// TODO Auto-generated method stub
		MasterVo masterVo = new MasterVo();
		Role rolebeanTemp = null;
		Session session = null;
		Transaction tx = null;
		
		Integer result =0;
		try
		{
           	session = HibernateUtil.getSession();
            tx = session.beginTransaction();
		
            
		
            rolebeanTemp = (Role) session.createCriteria(Role.class)	
					.add(Restrictions.eq("id",Integer.valueOf(id)))
					.uniqueResult();			
					
           
		if(rolebeanTemp != null){
			
			masterVo.setId(rolebeanTemp.getId());
		    	
			masterVo.setRolename(rolebeanTemp.getRolename());
		
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

		return masterVo;
	}

	}














package com.psas.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.primefaces.extensions.component.masterdetail.MasterDetail;

import com.psas.common.HibernateUtil;
import com.psas.dao.RoleInterface;
import com.psas.pojo.Role;

import com.psas.vo.MasterVo;


public class RoleImpl implements RoleInterface {

	



	@Override
	public int getsaverole(String rolename) throws Exception {		
		// TODO Auto-generated method stub
		
		Role roleTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		
		try{
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			roleTemp =  (Role) session.createCriteria(Role.class)
					.add(Restrictions.eq("name",rolename.toLowerCase().trim()).ignoreCase())				
					
					.uniqueResult();
			
			if (roleTemp != null) {

				result=2;	
			}else{
				
				roleTemp = new Role();
				
				roleTemp.setRolename(rolename);
				roleTemp.setStatus(true);
				
				
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
		List<MasterVo> RoleList = new ArrayList<MasterVo>();
		Role roleTemp = null;
		Session session = null;
		Transaction tx = null;
		MasterVo MasterVo=null;
		try
		{
           	session = HibernateUtil.getSession();
            tx = session.beginTransaction();
		
            
			@SuppressWarnings("unchecked")
			List<Role> getRoleList = (List<Role>) session
					.createCriteria(Role.class)					
					.list();
           
			for(Role roleDB :getRoleList){
			
			
			MasterVo= new MasterVo();
			
					
			MasterVo.setRolename(roleDB.getRolename());
			MasterVo.setStatus(roleDB.getStatus());
			
			
			RoleList.add(MasterVo);
			
			
		
			
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

		return RoleList;
	}
}


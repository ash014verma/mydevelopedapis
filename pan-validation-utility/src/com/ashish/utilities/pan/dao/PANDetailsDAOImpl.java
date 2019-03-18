package com.ashish.utilities.pan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ashish.utilities.pan.vo.PANDetailsVO;

@Transactional
public class PANDetailsDAOImpl {
	public  List<PANDetailsVO> fetchPANDetails(){
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("pan-validation-utility");
		EntityManager em = emf.createEntityManager();
		//Query query = em.createNamedQuery("IdentificationDetail.findAll");
		Query query = em.createQuery("select iden.identificationNumber, iden.customerFirstName, iden.customerMiddleName, iden.customerLastName \r\n" + 
				"		from  LoanDetail ld, IdentificationDetail iden where ld.loanAppId = iden.assocLoanAppId");
		List<Object>  results = query.getResultList();
		for(Object obj: results) {
			System.out.println(obj);
		}
		
		return query.getResultList();

	}

}

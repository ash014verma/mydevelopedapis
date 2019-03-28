package com.ashish.utilities.pan.dao;

import java.util.LinkedList;
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
		Query query = em.createNamedQuery("Details.fetchDetails");
		@SuppressWarnings("unchecked")
		List<Object[]>  results = query.getResultList();
		for(Object[] obj : results) {
			System.out.println("PANDetailsVO [identificationNumber=" + obj[0] + ", customerFirstName=" + obj[1]
					+ ", customerMiddleName=" + obj[2] + ", customerLastName=" + obj[3] + "]");
		}
		final List<PANDetailsVO> panDetailsList = new LinkedList<>();
		return panDetailsList;

	}

} 

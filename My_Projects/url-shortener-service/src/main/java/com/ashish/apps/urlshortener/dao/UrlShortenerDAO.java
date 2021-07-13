package com.ashish.apps.urlshortener.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.apps.urlshortener.entity.UrlInfo;

@Repository
@Named("urlShortenerDAO")
public class UrlShortenerDAO implements IUrlShortenerDAO {
	private static final Logger log = LoggerFactory.getLogger(UrlShortenerDAO.class);

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional("jpaTransactionManager")
	public void saveUrlInfo(UrlInfo urlInfo) {
		EntityManager em = null;
		try{
			em =  entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(urlInfo);
			em.getTransaction().commit();
		}finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}

	}

	@Override
	public String getTheOriginalLongUrl(String key) {
		EntityManager em = null;
		try{
			em =  entityManagerFactory.createEntityManager();
			TypedQuery<UrlInfo> urlInfoQuery = em.createNamedQuery("UrlInfo.findOriginalURL", UrlInfo.class);
			urlInfoQuery.setParameter("urlKey", key);
			if(urlInfoQuery.getSingleResult() != null) {
				return urlInfoQuery.getSingleResult().getUrlOriginal();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.ashish.apps.urlshortener.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.ashish.apps.urlshortener")
@PropertySource(value = {"classpath:db.properties"})
@EnableTransactionManagement
public class DataConfig {
	@Value( "${persistence.unit}" )
	private String persistenceUnitName;
	@Value( "${jdbc.password}" )
	private String encryptedPassword;
	private static final String SECRET_KEY = "oraclePWD";
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		  Map<String, Object> hashMap = new HashMap<>();
		  hashMap.put("javax.persistence.jdbc.password", decrypt());
		  return  Persistence.createEntityManagerFactory(persistenceUnitName, hashMap);
	}
	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		return new JpaTransactionManager();
	}
	
	private String decrypt() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPasswordCharArray(SECRET_KEY.toCharArray());
		return textEncryptor.decrypt(encryptedPassword);
		
	}

}

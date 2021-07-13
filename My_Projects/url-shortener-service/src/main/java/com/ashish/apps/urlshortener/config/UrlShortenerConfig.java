package com.ashish.apps.urlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ashish.apps.urlshortener.businessobject.IUrlShortenerBusinessObject;
import com.ashish.apps.urlshortener.businessobject.UrlShortenerBusinessObject;
import com.ashish.apps.urlshortener.dao.IUrlShortenerDAO;
import com.ashish.apps.urlshortener.dao.UrlShortenerDAO;
import com.ashish.apps.urlshortener.service.IUrlShortenerService;
import com.ashish.apps.urlshortener.service.UrlShortenerService;

@Configuration
@ComponentScan("com.ashish.apps.urlshortener")
@PropertySource(value = {"classpath:url-shortener.properties"})
public class UrlShortenerConfig {
	
	@Bean(name = "urlShortenerBusinessObject")
    public IUrlShortenerBusinessObject urlShortenerBusinessObject() {
		return new UrlShortenerBusinessObject();
    }
	
	@Bean(name = "urlShortenerService")
    public IUrlShortenerService urlShortenerService() {
		return new UrlShortenerService();
    }
	@Bean(name = "urlShortenerDAO")
    public IUrlShortenerDAO urlShortenerDAO() {
		return new UrlShortenerDAO();
    }

}

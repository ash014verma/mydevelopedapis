package com.ashish.apps.urlshortener.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.apps.urlshortener.config.DataConfig;
import com.ashish.apps.urlshortener.config.UrlShortenerConfig;
import com.ashish.apps.urlshortener.service.IUrlShortenerService;
import com.ashish.apps.urlshortener.service.UrlShortenerService;


public class UrlShortenerClientMain {
	private static Logger log = LoggerFactory.getLogger(UrlShortenerClientMain.class);
	private static AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();

	public static void main(String[] args){
		appContext.register(UrlShortenerConfig.class);
		appContext.register(DataConfig.class);
		appContext.refresh();
		//String longURL ="https://www.educative.io/courses/grokking-the-system-design-interview/m2ygV4E81AR";
		IUrlShortenerService urlShortenerDataService = appContext.getBean(UrlShortenerService.class);
	
			/*
			 * UrlInfo urlInfo = new UrlInfo(); urlInfo.setUrlOriginal(longURL);
			 * urlShortenerDataService.getTheShortenedUrl(urlInfo);
			 */
			
			String originalURL = urlShortenerDataService.redirectToOriginalLongUrl("http://tinyurl.com//fEXA0");
			log.info(originalURL);
		
	
	}
}

package com.ashish.apps.urlshortener.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ashish.apps.urlshortener.businessobject.IUrlShortenerBusinessObject;
import com.ashish.apps.urlshortener.entity.UrlInfo;
import com.ashish.apps.urlshortener.exception.UrlShortenerException;

@Service
@Named("urlShortenerService")
public class UrlShortenerService implements IUrlShortenerService{

	@Inject
	private IUrlShortenerBusinessObject urlShortenerDataBusinessObject;
	private static final Logger log = LoggerFactory.getLogger(UrlShortenerService.class);

	public String getTheShortenedUrl(UrlInfo urlInfo) {
		String shortLink = null;
		try {
			shortLink = urlShortenerDataBusinessObject.getTheShortenedUrl(urlInfo);
		}catch(UrlShortenerException use) {
			log.error("Some Error Occurred: ", use.getMessage());
		}catch(Exception e) {
			log.error("Some Unknown Error Occurred: ", e.getMessage());
		}
		return shortLink; 
	}

	@Override
	public String redirectToOriginalLongUrl(String shortlink)  {
		try {
			if(!StringUtils.isEmpty(shortlink)) {
				return urlShortenerDataBusinessObject.redirectToOriginalLongUrl(shortlink);
			}
		} catch (UrlShortenerException e) {
			log.error("Some Error Occurred: ", e.getMessage());
		}catch(Exception e) {
			log.error("Some Unknown Error Occurred: ", e.getMessage());
		}
		return null;
	}

}

package com.ashish.apps.urlshortener.businessobject;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.ashish.apps.urlshortener.dao.IUrlShortenerDAO;
import com.ashish.apps.urlshortener.entity.UrlInfo;
import com.ashish.apps.urlshortener.exception.UrlShortenerException;
import com.ashish.apps.urlshortener.util.UrlShortenerUtils;

@Named("urlShortenerBusinessObject")
public class UrlShortenerBusinessObject implements IUrlShortenerBusinessObject{
	private static final Logger log = LoggerFactory.getLogger(UrlShortenerBusinessObject.class);
	
	@Inject
	private IUrlShortenerDAO urlShortenerDataDAO;

	@Override
	public String getTheShortenedUrl(UrlInfo urlInfo) throws  UrlShortenerException {
		String shortLinkKey = null;
			if(!StringUtils.isEmpty(urlInfo.getUrlOriginal())) {
				 try {
					shortLinkKey = UrlShortenerUtils.getTheShortenedURLKey(urlInfo.getUrlOriginal());
				} catch (NoSuchAlgorithmException e) {
					throw new UrlShortenerException(e);
				}
				urlInfo.setUrlKey(shortLinkKey);
			}
			urlShortenerDataDAO.saveUrlInfo(urlInfo);
		return "http://tinyurl.com/" + shortLinkKey;
	}

	@Override
	public String redirectToOriginalLongUrl(String shortlink) throws UrlShortenerException {
		String key = shortlink.substring(shortlink.length() - 6);
		return urlShortenerDataDAO.getTheOriginalLongUrl(key);
	}

	

}

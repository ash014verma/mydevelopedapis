package com.ashish.apps.urlshortener.businessobject;

import com.ashish.apps.urlshortener.entity.UrlInfo;
import com.ashish.apps.urlshortener.exception.UrlShortenerException;

public interface IUrlShortenerBusinessObject {
	public String getTheShortenedUrl(UrlInfo urlInfo) throws  UrlShortenerException;
	public String redirectToOriginalLongUrl(String shortlink) throws UrlShortenerException;
}

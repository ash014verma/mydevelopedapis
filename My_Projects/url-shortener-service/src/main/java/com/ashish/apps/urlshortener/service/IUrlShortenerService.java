package com.ashish.apps.urlshortener.service;

import com.ashish.apps.urlshortener.entity.UrlInfo;

public interface IUrlShortenerService {
	public String getTheShortenedUrl(UrlInfo urlInfo);
	public String redirectToOriginalLongUrl(String shortlink);
}

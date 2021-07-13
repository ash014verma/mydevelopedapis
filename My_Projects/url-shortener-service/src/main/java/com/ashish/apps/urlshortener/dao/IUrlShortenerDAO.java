package com.ashish.apps.urlshortener.dao;

import com.ashish.apps.urlshortener.entity.UrlInfo;

public interface IUrlShortenerDAO {
	public void saveUrlInfo(UrlInfo urlInfo);
	public String getTheOriginalLongUrl(String key);
}

package com.ashish.apps.urlshortener.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the URL_INFO database table.
 * 
 */
@Entity
@Table(name="URL_INFO")
@NamedQueries({
@NamedQuery(name="UrlInfo.findAll", query="SELECT u FROM UrlInfo u"),
@NamedQuery(name="UrlInfo.findOriginalURL", query="SELECT u FROM UrlInfo u where u.urlKey = :urlKey")
})
public class UrlInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="URL_KEY")
	private String urlKey;

	@Column(name="URL_ORIGINAL")
	private String urlOriginal;

	public UrlInfo() {
	}

	public String getUrlKey() {
		return this.urlKey;
	}

	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}

	public String getUrlOriginal() {
		return this.urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

}
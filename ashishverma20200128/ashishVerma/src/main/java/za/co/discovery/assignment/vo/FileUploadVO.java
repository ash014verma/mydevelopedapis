package za.co.discovery.assignment.vo;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private CommonsMultipartFile fileData;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}


}

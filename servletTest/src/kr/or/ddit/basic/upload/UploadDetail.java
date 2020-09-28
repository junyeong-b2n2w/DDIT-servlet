package kr.or.ddit.basic.upload;

import java.io.Serializable;


// Uplode 되 파일 정돕ㄱ ㅏ저잘팡
public class UploadDetail implements Serializable{
	private long fileSize;  	//파일용ㄹㅑㅇ
	private String fileName;	//파일이름
	private String uploadStatus;//업로드 성공여부
	
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
	
}

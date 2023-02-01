package printer.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String fileName;
	private String fileUpPath;

	@Column(name ="instantPrint", columnDefinition= "BOOLEAN")
	private boolean instantPrint;
	
	@Column(name="isPrintedBefore", columnDefinition = "BOOLEAN")
	private boolean isPrintedBefore;
	
	@Column(name="uploadDate", columnDefinition = "datetime")
	private String uploadDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileUpPath() {
		return fileUpPath;
	}
	public void setFileUpPath(String fileUpPath) {
		this.fileUpPath = fileUpPath;
	}
	
	public boolean isInstantPrint() {
		return instantPrint;
	}
	public void setInstantPrint(boolean instantPrint) {
		this.instantPrint = instantPrint;
	}
	
	public boolean isPrintedBefore() {
		return isPrintedBefore;
	}
	public void setPrintedBefore(boolean isPrintedBefore) {
		this.isPrintedBefore = isPrintedBefore;
	}
	
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public UserModel() {
		super();
	}
	
	public UserModel(int id, String fileName, String fileUpPath, boolean instantPrint, boolean isPrintedBefore,
			String uploadDate) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileUpPath = fileUpPath;
		this.instantPrint = instantPrint;
		this.isPrintedBefore = isPrintedBefore;
		this.uploadDate = uploadDate;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fileName=" + fileName + ", fileUpPath=" + fileUpPath + ", instantPrint="
				+ instantPrint + ", isPrintedBefore=" + isPrintedBefore + ", uploadDate=" + uploadDate + "]";
	}
	
}

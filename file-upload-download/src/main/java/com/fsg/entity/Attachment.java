package com.fsg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Attachment {
	
	
	    @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;
	    private String fileType;

	    @Lob
	    private byte[] data;

		public Attachment() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Attachment( String fileName, String fileType, byte[] data) {
			super();
			
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}
	    
	    

}

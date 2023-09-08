package com.fsg.service;

import org.springframework.web.multipart.MultipartFile;

import com.fsg.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;
	
	public Attachment getAttachment(String fileId) throws Exception;

}

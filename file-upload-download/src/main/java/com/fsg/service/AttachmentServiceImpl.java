package com.fsg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fsg.entity.Attachment;
import com.fsg.repo.AttachmentRepo;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	@Autowired
	private AttachmentRepo attachmentRepo;

	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence "
	                + fileName);
	            }

	            Attachment attachment
	                    = new Attachment(fileName,
	                    file.getContentType(),
	                    file.getBytes());
	            return attachmentRepo.save(attachment);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}

	
	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		 return attachmentRepo
	                .findById(fileId)
	                .orElseThrow(
	                        () -> new Exception("File not found with Id: " + fileId));
	    }
	}



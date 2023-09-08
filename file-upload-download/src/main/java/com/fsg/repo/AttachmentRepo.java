package com.fsg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsg.entity.Attachment;

public interface AttachmentRepo  extends JpaRepository<Attachment, String> {
}

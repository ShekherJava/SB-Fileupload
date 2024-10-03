package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileEntity;
import com.example.demo.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	FileRepository fileRepo;
	
	public FileEntity storeFile(MultipartFile file) throws IOException {
		FileEntity fileEntity = new FileEntity();
		fileEntity.setFileName(file.getOriginalFilename());
		fileEntity.setFileType(file.getContentType());
		fileEntity.setFileData(file.getBytes());
		return fileRepo.save(fileEntity);
	}
	
	public List<FileEntity> getAllFiles() {
		return fileRepo.findAll();
	}

}

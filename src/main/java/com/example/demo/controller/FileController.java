package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	FileService  fileService;
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
		model.addAttribute("files", fileService.getAllFiles());
		return "index";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
		try {
			fileService.storeFile(multipartFile);
			model.addAttribute("message", "File uploaded successfully");
		}
		catch(Exception ex) {
			model.addAttribute("message", "File upload failed " + ex.getMessage());
		}
		
		return "redirect:/";		
	}
	

}

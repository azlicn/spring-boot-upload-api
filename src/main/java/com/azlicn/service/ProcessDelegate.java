package com.azlicn.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProcessDelegate {
	
	private final Logger logger = LoggerFactory.getLogger(ProcessDelegate.class);
	
	@Autowired
    private Environment env;
	
	@Async
	public void save(List<MultipartFile> files) throws IOException, InterruptedException {
	    	
	    	String directory = env.getProperty("azlicn.paths.uploadedFiles");

	        for (MultipartFile file : files) {

	            if (file.isEmpty()) {
	                continue;
	            }

	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(directory + file.getOriginalFilename());
	            
	            Files.write(path, bytes);

	        }

	}
	
}

package com.azlicn.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.azlicn.service.ProcessDelegate;

@RestController
public class FileUploadController {

    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    
    @Autowired
    private ProcessDelegate processDelegate;

    @RequestMapping(value = "/api/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] uploadfiles) {

        logger.debug("Multiple files uploaded!");

        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" | "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity("Please select a file!", HttpStatus.OK);
        }

        try {

        	processDelegate.save(Arrays.asList(uploadfiles));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (InterruptedException e) {
        	logger.warn("Error processing request", e);
		}

        return new ResponseEntity("Successfully uploaded : "
                + uploadedFileName, HttpStatus.OK);

    }


}

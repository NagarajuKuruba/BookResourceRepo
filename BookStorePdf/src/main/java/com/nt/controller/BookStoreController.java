package com.nt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.service.BookStoreService;

@RestController
public class BookStoreController {
	@Autowired
	private BookStoreService service;
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile uploadfile) throws IOException {
		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}
          service.saveBook(uploadfile);
		return new ResponseEntity("please select a file!", HttpStatus.OK);
	}

}

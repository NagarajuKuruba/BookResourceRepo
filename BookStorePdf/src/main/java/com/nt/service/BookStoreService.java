package com.nt.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.domain.Report;

public interface BookStoreService {
	
	public String saveBook(MultipartFile uploadfile) throws IOException;
	
   
}

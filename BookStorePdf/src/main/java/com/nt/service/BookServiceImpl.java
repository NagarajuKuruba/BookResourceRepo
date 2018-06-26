package com.nt.service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nt.domain.Report;

@Service
public class BookServiceImpl implements BookStoreService {

	@Autowired
	private GridFsTemplate template;
    
	private String pdfFileId = "";

	@Override
	public String saveBook(MultipartFile uploadfile) throws IOException {
		System.out.println("Service:saveBook(): in");
		DBObject metaData = new BasicDBObject();
		metaData.put("organization", "JavaSampleApproach");
        
		
		metaData.put("type", "pdf");
		
		byte [] byteArr=uploadfile.getBytes();
		InputStream inputStream = new ByteArrayInputStream(byteArr);
		// Store file to MongoDB
		pdfFileId = template.store(inputStream, "abc", "pdf", metaData).getId().toString();
		System.out.println("ImageFileId = " + pdfFileId);
		
		System.out.println("serivce:object is saved");
		return pdfFileId;
	}
	
}

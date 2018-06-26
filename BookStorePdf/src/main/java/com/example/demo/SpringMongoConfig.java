package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.nt.domain.Report;
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration{
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

	@Override
	protected String getDatabaseName() {
		return "embeded_db";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
	}

}

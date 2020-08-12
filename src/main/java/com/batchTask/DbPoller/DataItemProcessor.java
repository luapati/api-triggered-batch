package com.batchTask.DbPoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class DataItemProcessor implements ItemProcessor<DataModel, DataModel>{

	private static final Logger log = LoggerFactory.getLogger(DataItemProcessor.class);
	
	@Override
	public DataModel process(DataModel item) throws Exception {
		log.info("Reading data from the database: " + item);
		return item;
	}
	

}

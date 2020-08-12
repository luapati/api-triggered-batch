package com.batchTask.DbPoller;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

//import javax.activation.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsRowMapper userDetailsRowMapper;
	
	@Bean
	public UserDetailsRowMapper userDetailsRowMapper () {
		return new UserDetailsRowMapper();
	}
	
	@Bean
	public UserDetailsJobListener userDetailsJobListener() {
		return new UserDetailsJobListener();
	}

	@Bean
	public JdbcCursorItemReader<DataModel> reader() {
		JdbcCursorItemReader<DataModel> reader = new JdbcCursorItemReader<DataModel>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id,filename,interface,status,ack FROM user");
		reader.setRowMapper(userDetailsRowMapper);
		return reader;
	}
	
	
	@Bean
	public DataItemProcessor dataItemprocessor() {
		return new DataItemProcessor();
	}
	
	@Bean
	public NoOpItemWriter noOpWriter() {
		return new NoOpItemWriter();
	}
	
	@Bean
	public Job readDataModelJob (UserDetailsJobListener userDetailsJobListener) {
		return jobBuilderFactory.get("readDataModelJob")
				.incrementer(new RunIdIncrementer())
				.listener(userDetailsJobListener)
				.flow(Readstep(dataItemprocessor()))
				.end()
				.build();
	} 
	
	
	@Bean
	public Step Readstep(DataItemProcessor dataItemprocessor) {
		return stepBuilderFactory.get("ReadStep")
				.<DataModel, DataModel> chunk(10)
				.reader(reader())
				.processor(dataItemprocessor)
				.writer(noOpWriter())
				.allowStartIfComplete(true)
				.build();
	}
	
//	@Bean(name="job2")
//	public Job updateAckJob(UserDetailsJobListener userDetailsJobListener) {
//		return jobBuilderFactory.get("updateAckJob")
//				.incrementer(new RunIdIncrementer())
//				.listener(userDetailsJobListener)
//				.flow(updateAck())
//				.end()
//				.build();
//	}
//	
//	@Bean
//	public Step updateAck() {
//		return stepBuilderFactory.get("UpdateAckStep")
//				.tasklet(ackProcessor())
//				.allowStartIfComplete(true)
//				.build();
//	}
}

package com.batchTask.DbPoller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import com.batchTask.DbPoller.DataModel;



public class UserDetailsRowMapper implements RowMapper<DataModel> {

	
	@Override
	public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataModel dataModel = new DataModel();
		dataModel.setId(rs.getInt("id"));
		dataModel.setFileName(rs.getString("filename"));
		dataModel.setInterFace(rs.getString("interface"));
		dataModel.setStatus(rs.getString("status"));
		dataModel.setAck(rs.getString("ack"));
		
		return dataModel;
	}

}

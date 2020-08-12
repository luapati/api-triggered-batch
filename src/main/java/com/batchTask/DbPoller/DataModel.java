package com.batchTask.DbPoller;

public class DataModel {
	
	private int id;
	private String fileName;
	private String interFace;
	private String status;
	private String ack;
	
	public DataModel() {
		super();
	}
	public DataModel(int id,String fileName, String interFace, String status, String ack) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.interFace = interFace;
		this.status = status;
		this.ack = ack;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getInterFace() {
		return interFace;
	}
	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAck() {
		return ack;
	}
	public void setAck(String ack) {
		this.ack = ack;
	}
	@Override
	public String toString() {
		return "DataModel [fileName=" + fileName + ", interFace=" + interFace + ", status=" + status + ", ack=" + ack + "]";
	}

}

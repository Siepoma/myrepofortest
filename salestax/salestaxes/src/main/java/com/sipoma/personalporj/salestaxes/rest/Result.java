package com.sipoma.personalporj.salestaxes.rest;

public class Result {
	
	String resultCode;
	String resultDescription;
	
	
	public Result(String resultCode, String resultDescription) {
		super();
		this.resultCode = resultCode;
		this.resultDescription = resultDescription;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
}

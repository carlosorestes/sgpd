package com.sgpd.br.dto;

import java.io.Serializable;

public class VariableExecution implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String variableName;
	private String value;
	private String type;
	
	public VariableExecution() {
	}

	public VariableExecution(String variableName, String value, String type) {
		this.variableName = variableName;
		this.value = value;
		this.type = type;
	}
	
	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

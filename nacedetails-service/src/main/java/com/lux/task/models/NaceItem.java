package com.lux.task.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "nacedetails")
public class NaceItem {
	
	public NaceItem() {
		super();
	}

	@Id
	@ApiModelProperty(notes="The unique orderid of the Nace Item")
	private int oderid;
	@ApiModelProperty(notes="The Nace Item Code")
	private String code;
	@ApiModelProperty(notes="The Nace Item Description")
	private String description;
	
	public int getOderid() {
		return oderid;
	}

	public void setOderid(int oderid) {
		this.oderid = oderid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NaceItem(int oderid, String code, String description) {
		super();
		this.oderid = oderid;
		this.code = code;
		this.description = description;
	}

	@Override
	public String toString() {
		return "NaceItem [oderid=" + oderid + ", code=" + code + ", description=" + description + "]";
	}
	
	
}

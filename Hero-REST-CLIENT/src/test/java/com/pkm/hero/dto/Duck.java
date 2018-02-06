package com.pkm.hero.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"duckId", "duckName", "quack", "quackedOff"})
public class Duck {

	private Integer duckId;
	private String duckName;
	private String quack;
	private Boolean quackedOff;

	public Duck() {
		duckId = null;
		duckName = null;
		quack = "no quack";
		quackedOff = false;
		
	}

	public Duck(Integer duckId) {
		this();
		this.duckId = duckId;
	}
	
	public Duck(Integer duckId, String duckName) {
		this(duckId);
		this.duckName = duckName;
	}

	public Duck(Integer duckId, String duckName, String quack) {
		this(duckId, duckName);
		this.quack = quack;
	}

	public Duck(Integer duckId, String duckName, String quack, Boolean quackedOff) {
		this(duckId, duckName, quack);
		this.quackedOff = quackedOff;
	}

	/**
	 * @return the duckId
	 */
	public Integer getDuckId() {
		return duckId;
	}

	/**
	 * @param duckId the duckId to set
	 */
	public void setDuckId(Integer duckId) {
		this.duckId = duckId;
	}

	/**
	 * @return the duckName
	 */
	public String getDuckName() {
		return duckName;
	}

	/**
	 * @param duckName the duckName to set
	 */
	public void setDuckName(String duckName) {
		this.duckName = duckName;
	}

	/**
	 * @return the quackedOff
	 */
	public Boolean getQuackedOff() {
		return quackedOff;
	}

	/**
	 * @param quackedOff the quackedOff to set
	 */
	public void setQuackedOff(Boolean quackedOff) {
		this.quackedOff = quackedOff;
	}

	/**
	 * @return the quack
	 */
	public String getQuack() {
		return quack;
	}

	/**
	 * @param quack the quack to set
	 */
	public void setQuack(String quack) {
		this.quack = quack;
	}

}

package com.yapp.ohdoking.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "People")
public class People implements Serializable {

	private static final long serialVersionUID = -7788619177798333712L;
	
	private Long id;
	private String name;
	private int age;
	private String sex;
	private String etc;
	private Date publishedOn;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(length = 15, nullable = false)
	public String getName() {
		return name;
	}
	
	@Column
	public int getAge() {
		return age;
	}
	@Column
	public String getSex() {
		return sex;
	}
	@Column
	public String getEtc() {
		return etc;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	@Column(name = "published_date",columnDefinition="DATE DEFAULT SYSDATE", insertable=false)
	public Date getPublishedOn() {
		return publishedOn;
	}
	
	
	/*
	 * Setter
	 */
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	
	
	
}

package com.ruchi.backendProject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Category {

	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getImageurl() 
	{
		return imageurl;
	}
	public void setImageurl(String imageurl)
	{
		this.imageurl = imageurl;
	}
	public boolean isActive() 
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column (name="description")
	private String desc;
	
	@Column (name="image_url")
	private String imageurl;
	
	private boolean active;
	
}

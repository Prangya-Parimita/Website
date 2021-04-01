package com.ruchi.backendProject.dto;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "user_detail")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotBlank(message="Please enter your First Name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message="Please enter your Last Name")
	private String lastName;
	
	private String role;
	
	@Column(name = "contact_number")
	@NotBlank(message="Please enter your Contact Number")
	private String contactNumber;
	
	@NotBlank(message="Please enter your Email Id")
	@Email(message="Incorrect email id format!")
	private String email;
	
	@NotBlank(message="Please enter your PassWord")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	private boolean enabled = true;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role = role;
	}
	public String getContactNumber() 
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getConfirmPassword() 
	{
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword)  // later
	{
		this.confirmPassword = confirmPassword;
	}
	public boolean isEnabled() 
	{
		return enabled;
	}
	public void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
	}

	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)  // mappedBy="user" showing user is the parent table object and cascade  will create cart table automatically
	private Cart cart;                                     // adding the cart object for linking to user table.
	
    public Cart getCart()
    {
		return cart;
	}
	public void setCart(Cart cart)
	{
		this.cart = cart;
	}

	
	}

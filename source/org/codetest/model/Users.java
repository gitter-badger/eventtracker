package org.codetest.model;

import org.codetest.annotations.Column;
import org.codetest.annotations.Table;
import org.codetest.persistence.Entity;

@Table(name="UsersTable")
public class Users extends Entity
{
	Long userID;
	String emailID;
	String userName;
	String password;
	Long createdTime;
	Long updatedTime;

	@Column(name="_EvenID", type="Long")
	public Long getUserID()
	{
		return userID;
	}

	public void setUserID(Long userID)
	{
		this.userID = userID;
	}

	@Column(name="_EmaiID", type="String")
	public String getEmailID()
	{
		return emailID;
	}

	public void setEmailID(String emailID)
	{
		this.emailID = emailID;
	}

	@Column(name="_UserName", type="String")
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name="_Password", type="String")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name="_CreatedTime", type="Long")
	public Long getCreatedTime()
	{
		return createdTime;
	}

	public void setCreatedTime(Long createdTime)
	{
		this.createdTime = createdTime;
	}
	
	@Column(name="_UpdatedTime", type="Long")
	public Long getUpdatedTime()
	{
		return updatedTime;
	}

	public void setUpdatedTime(Long updatedTime)
	{
		this.updatedTime = updatedTime;
	}
	
}

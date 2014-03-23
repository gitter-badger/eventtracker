package org.codetest.persistence;

import org.codetest.model.Users;

public class Sample
{
	public static void main(String args[]) throws Exception
	{
		Users user = new Users();
		user.setUserName("Hyder Ali");
		user.setEmailID("hyder.ali@zohocorp.com");
		user.setPassword("hyder.ali");
		user.setCreatedTime(System.currentTimeMillis());
		user.setUpdatedTime(System.currentTimeMillis());
		user.insert(user);
	}
}


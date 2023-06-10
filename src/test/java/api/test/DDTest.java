package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		user userPayload=new user();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=2,dataProvider="UserName",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName)
	{
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

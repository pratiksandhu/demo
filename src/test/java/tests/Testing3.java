package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();
	
	
  @Test (priority = 1) // create new user test
  public void createUser() {
	  System.out.println("I'm in Home test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(4>3, "Verifying Element");
	  System.out.println("After assertion");
	  Assert.assertEquals("abc", "abc");
  }
 
  @Test (priority = 2, dependsOnMethods="createUser") //edit user test@test.com
  public void editUser() {
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assertion");
	  softAssert.assertAll(); // similar to error collector in Junit
  }
  
  @Test (priority = 3, dependsOnMethods = {"editUser","createUser"})  //delet user test@test.com
  public void deleteUser() {
	  System.out.println("I'm in end test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assertion");
	  softAssert.assertEquals("abc","abc1");
	  System.out.println("After second assertion");
	  softAssert.assertAll();
	  
	  
  }
}

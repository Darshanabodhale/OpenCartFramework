package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_accountRegistrationTest extends BaseClass{
	
	@Test(groups ={"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("****** Starting TC01_accountRegistrationTest  *******");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer details...");
		
		regPage.setFirstName(randomString().toUpperCase());  //random name
		regPage.setLastName(randomString().toUpperCase());   //random last name in upper case
		regPage.setEmail(randomString()+"@gmail.com");     //Random generate email Address
		regPage.setTelephone(randomNumber());
		
		
		
		String newpass = randomPass();
				
		regPage.setPassword(newpass);
		regPage.setConfirmPass(newpass);
		
		regPage.ChckAgree();
		regPage.clickSubmit();
		
		logger.info("Validating expected message...");
		String confmMsg = regPage.getConfirmationMesssage();
		
		if(confmMsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		
		}
		catch(Exception e){
			Assert.fail();
		}
		
		logger.info("****** Finished TC01_accountRegistrationTest  *******");
		
		
	}
	
	
}
package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

	public class TC02_LoginTest extends BaseClass{

		@Test(groups= {"Sanity", "Master"})
		public void verify_Login() {
			logger.info("******* Starting TC02_LoginTest *******");
			
			try {
				
		
			//HomePage
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLoginbtn();
			
			//MyAccountPage
			MyAccountPage ma = new MyAccountPage(driver);
			boolean targetPage = ma.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true, "Login Failed");
			}catch(Exception e) {
				Assert.fail();
			}
			logger.info("******* Finished TC02_LoginTest *******");
		}
		
		
	}
	


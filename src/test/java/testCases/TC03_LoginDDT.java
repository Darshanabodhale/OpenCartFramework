package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass{

	//Data is valid - login success - test pass - logout
	//Data is valid - login failed - test fail
	
	//Data is invalid - login success - test fail - logout
	//Data is invalid - login failed - test pass - logout
	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class, groups = "Datadriven")  //Getting data providers from different class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("******** Starting TC03_LoginDDT *********");
		
		try {
		//HomePage
				HomePage hp = new HomePage(driver);
				
				hp.clickMyAccount();
				hp.clickLogin();
				
				//LoginPage
				LoginPage lp = new LoginPage(driver);
				
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLoginbtn();
				
				//MyAccountPage
				MyAccountPage ma = new MyAccountPage(driver);
				boolean targetPage = ma.isMyAccountPageExists();
				
				if(exp.equalsIgnoreCase("Valid")) {
					if(targetPage==true) {
						Assert.assertTrue(true);
						ma.clickLogout();
					}else {
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("Invalid")) {
					if(targetPage==true) {
						Assert.assertTrue(false);
						ma.clickLogout();
					}else {
						Assert.assertTrue(true);
					}
				}
				
		}catch(Exception e) {
			Assert.fail();
		}
				
				logger.info("******** Finished TC03_LoginDDT *********");
				
	}
}

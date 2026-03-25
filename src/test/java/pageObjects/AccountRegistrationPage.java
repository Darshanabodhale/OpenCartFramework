package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFName;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement txtLName;
	
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement txtTlephone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtCnfmPass;
	
	//input[@value='0']
	
	@FindBy(xpath ="//input[@value='0']")
	WebElement rdbtnSubNo;
	
	@FindBy(xpath ="//input[@value='0']")
	WebElement rdbtntxtSubyes;
	
	@FindBy(xpath ="//input[@name='agree']")
	WebElement chkAgree;
	
	
	@FindBy(xpath ="//input[@value='Continue']")
	WebElement btnContinue;
	
	//h1[normalize-space()='Your Account Has Been Created!']
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName (String fname) {
		txtFName.sendKeys(fname);
	}
	
	public void setLastName (String lname) {
		txtLName.sendKeys(lname);
	}
		
	public void setEmail (String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone (String tel) {
		txtTlephone.sendKeys(tel);
	}
	
	public void setPassword (String pwd) {
		txtPass.sendKeys(pwd);
	}	
	
	public void setConfirmPass (String pwd) {
		txtCnfmPass.sendKeys(pwd);
	}	
	
	public void clickSubscribe () {
		rdbtnSubNo.click();
	}
	
	public void ChckAgree () {
		chkAgree.click();
	}
		
	public void clickSubmit () {
		btnContinue.click();
	}
	
	public String getConfirmationMesssage() {
		try {		
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}	
}

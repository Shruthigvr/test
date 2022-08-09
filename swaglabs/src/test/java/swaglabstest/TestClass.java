package swaglabstest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ict.constants.AutomationConstants;
import com.ict.pages.InventoryPage;
import com.ict.pages.LoginPage;
import com.ict.utilities.ExcelUtility;

public class TestClass extends SauceDemoTestBase{
	LoginPage objLogin;
	InventoryPage objInventory;
	
	@Test(priority=1)
    public void verifyWebsiteURL() throws IOException, InterruptedException {
    //Create Login Page object
    objLogin = new LoginPage(driver);
    //login to application
    String expectedURL =AutomationConstants.HOMEPAGE_URL;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Swag Labs website home page launched successfully... "+actualURL);
	}
	
	@Test(priority=1)
    public void verifyValidLogin() throws IOException, InterruptedException {
    //Create Login Page object
    objLogin = new LoginPage(driver);
    //login to application
    String username = ExcelUtility.getCellData(0, 0);
    String password = ExcelUtility.getCellData(0, 1);
    objLogin.setUserName(username);
    objLogin.setPassword(password);
    objLogin.clickLogin();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); 
    String expectedURL =AutomationConstants.INVENTORYPAGE_URL;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    
    System.out.println("Valid Username and Password..Successfully Redirected to Inventory Page..."+actualURL);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); 
    objInventory= new InventoryPage(driver);
    objInventory.selectItemAddtoCart(actualURL);
	}
	
	@Test(priority=1)
	 public void verifyInvalidLogin() throws IOException {
		    //Create Login Page object
		    objLogin = new LoginPage(driver);
		    //login to application
		    String username = ExcelUtility.getCellData(1, 0);
		    String password = ExcelUtility.getCellData(1, 1);
		    objLogin.setUserName(username);
		    objLogin.setPassword(password);
		    objLogin.clickLogin();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		    String expectedErrorMessageUserPass=objLogin.getInvalidMessage();
		    String actualErrorMessageUserPass=AutomationConstants.INVALID_LOGIN_MESSAGE;
		    Assert.assertEquals(expectedErrorMessageUserPass,actualErrorMessageUserPass);
		    System.out.println("Invalid Username and Password.."+expectedErrorMessageUserPass);
			}
	@Test(priority=1)
	 public void blankPassword() throws IOException {
		    //Create Login Page object
		    objLogin = new LoginPage(driver);
		    //login to application
		    String username = ExcelUtility.getCellData(2, 0);
		    objLogin.setUserName(username);
		    objLogin.clickLogin();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); 
		    String expectedErrorMessageBlankPass=objLogin.getInvalidMessage();
		    String actualErrorMessageBlankPass=AutomationConstants.BLANK_PASSWORD;
		    Assert.assertEquals(expectedErrorMessageBlankPass,actualErrorMessageBlankPass);
		    System.out.println("Blank Password.."+expectedErrorMessageBlankPass);
			}
	@Test(priority=1)
	 public void blankUsername() throws IOException {
		    //Create Login Page object
		    objLogin = new LoginPage(driver);
		    //login to application
		    String password = ExcelUtility.getCellData(3, 1);
		    objLogin.setPassword(password);
		    objLogin.clickLogin();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); 
		    String expectedErrorMessageBlankUser=objLogin.getInvalidMessage();
		    String actualErrorMessageBlankUser=AutomationConstants.BLANK_USERNAME;
		    Assert.assertEquals(expectedErrorMessageBlankUser,actualErrorMessageBlankUser);
		    System.out.println("Blank Username.."+expectedErrorMessageBlankUser);
			}
	@Test(priority=1)
	 public void wrongUsername() throws IOException {
		    //Create Login Page object
		    objLogin = new LoginPage(driver);
		    //login to application
		    String username = ExcelUtility.getCellData(4, 0);
		    String password = ExcelUtility.getCellData(4, 1);
		    objLogin.setUserName(username);
		    objLogin.setPassword(password);
		    objLogin.clickLogin();
		    String expectedErrorMessageUserPass=objLogin.getInvalidMessage();
		    String actualErrorMessageUserPass=AutomationConstants.INVALID_LOGIN_MESSAGE;
		    Assert.assertEquals(expectedErrorMessageUserPass,actualErrorMessageUserPass);
		    System.out.println("Wrong Username.."+expectedErrorMessageUserPass);			  
			}
	@Test(priority=1)
	 public void wrongPassword() throws IOException {
		    //Create Login Page object
		    objLogin = new LoginPage(driver);
		    //login to application
		    String username = ExcelUtility.getCellData(5, 0);
		    String password = ExcelUtility.getCellData(5, 1);
		    objLogin.setUserName(username);
		    objLogin.setPassword(password);
		    objLogin.clickLogin();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); 
		    String expectedErrorMessageUserPass=objLogin.getInvalidMessage();
		    String actualErrorMessageUserPass=AutomationConstants.INVALID_LOGIN_MESSAGE;
		    Assert.assertEquals(expectedErrorMessageUserPass,actualErrorMessageUserPass);
		    System.out.println("Wrong Password.."+expectedErrorMessageUserPass);		
			}

	
}

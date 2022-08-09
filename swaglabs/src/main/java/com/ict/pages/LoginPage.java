package com.ict.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
    
    @FindBy(id="user-name")
    private WebElement username;
    @FindBy(id="password")
    private WebElement password;    
    @FindBy(id="login-button")
    private WebElement login;    
    @FindBy(xpath="//div[@class='error-message-container error']/h3")
    private WebElement errorMessage;
   
        
    public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    public void setUserName(String strUserName){
    	username.sendKeys(strUserName);     
    }

    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }
    public String getInvalidMessage(){
    	return errorMessage.getText();
    }
    
    
    public void clickLogin()
    {
    	login.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}

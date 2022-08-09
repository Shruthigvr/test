package com.ict.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {
	WebDriver driver;
	@FindBy(xpath="//div[@class='inventory_item_name'][1]")
    private WebElement loginConfirmElement;
	private WebElement cartButtonElement;

	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.loginConfirmElement=driver.findElement(By.xpath("//span[@class='title']"));
		this.cartButtonElement=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	}
	
	public void selectItemAddtoCart(String item) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> items= driver.findElements(By.xpath("//div[@class='inventory_item']"));
		for( WebElement i : items) {
			String itemName= i.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
			
			if(itemName.contains(item)) {
				i.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
			}
		}
	}
	
	public void clickCartButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cartButtonElement.click();
	}
	

}

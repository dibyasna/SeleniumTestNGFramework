package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue) {

		switch(identifierType){
		case "xpath":
			return BaseTest.driver.findElement(By.xpath(identifierValue)); 
		case "id":
			return BaseTest.driver.findElement(By.id(identifierValue)); 
		case "name":
			return BaseTest.driver.findElement(By.name(identifierValue)); 
		case "className":
			return BaseTest.driver.findElement(By.className(identifierValue)); 
		case "tagName":
			return BaseTest.driver.findElement(By.tagName(identifierValue)); 
		case "cssSelector":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue)); 
		case "linkText":
			return BaseTest.driver.findElement(By.linkText(identifierValue)); 
		case "partialLinkText":
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue)); 
		default:
			return null;
		}
	}
	
	public List<WebElement> getWebElements(String identifierType, String identifierValue) {

		switch(identifierType){
		case "xpath":
			return BaseTest.driver.findElements(By.xpath(identifierValue)); 
		case "id":
			return BaseTest.driver.findElements(By.id(identifierValue)); 
		case "name":
			return BaseTest.driver.findElements(By.name(identifierValue)); 
		case "className":
			return BaseTest.driver.findElements(By.className(identifierValue)); 
		case "tagName":
			return BaseTest.driver.findElements(By.tagName(identifierValue)); 
		case "cssSelector":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue)); 
		case "linkText":
			return BaseTest.driver.findElements(By.linkText(identifierValue)); 
		case "partialLinkText":
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue)); 
		default:
			return null;
		}
	}

}

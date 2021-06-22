package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
	WebDriver driver;
	public ElementControl(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public void setText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	public void clear(WebElement element)
	{
		element.clear();
	}
	public boolean isEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getTextFromAlert()
	{
		return driver.switchTo().alert().getText();
	}
	
	public void selectTextviaVisibleText(WebElement element, String text)
	{
		Select selDropDown = new Select(element);
		selDropDown.selectByVisibleText(text);
	}

}

package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	private TakesScreenshot camera;

	public ScreenshotUtil(WebDriver driver)
	{
		camera = (TakesScreenshot) driver;
	}

	public void captureAndSaveScreenShot(String fileName) throws Exception
	{
		fileName = fileName.trim();
		File imgFile, tempFile;
		imgFile = new File(fileName);
		
		if(imgFile.exists())
		{
			throw new Exception("File already exit");
		}
		
		tempFile = camera.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tempFile, imgFile);
	}

}

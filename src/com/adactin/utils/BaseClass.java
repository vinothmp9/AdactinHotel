package com.adactin.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String bname) {
		try {
			if (bname.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (bname.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (bname.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\driver\\geckoServer.exe");
				driver = new FirefoxDriver();
			} else {
				System.out.println("browser invalid");
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void inputdata(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void clickButton(WebElement ele) {
		ele.click();
	}

	public static void explicitwait(int secs, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void passurl(String url) {
		driver.get(url);
	}

	public static void ddlb_Select(WebElement ele, String selectby, String value) {
		Select s = new Select(ele);
		switch (selectby) {
		case "index":
			s.selectByIndex(Integer.parseInt(selectby));
			break;
		case "value":
			s.selectByValue(value);
			break;
		case "visibletext":
			s.selectByVisibleText(value);
			break;
		default:
			System.out.println("check selectby keyword");
			break;

		}
	}
	
	
	public static void screenshot(String number) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("E:\\Selenium\\workspace\\AdactinHotel\\testscreenshot"+number+".png");
		FileUtils.copyFile(sourcefile, destinationfile);
	}
}

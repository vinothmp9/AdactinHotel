package com.adactin.driverscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.adactin.utils.BaseClass;

public class AdactinHotel {
public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		driver=BaseClass.browserLaunch("chrome");
		BaseClass.passurl("http://adactin.com/HotelApp/index.php");
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		BaseClass.inputdata(username, "vinothmp9");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		BaseClass.inputdata(password, "vinothvinoth");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
		BaseClass.clickButton(loginBtn);
		
		WebElement location = driver.findElement(By.xpath("//*[@id='location']"));
		BaseClass.ddlb_Select(location, "value", "Melbourne");
		
		WebElement hotels = driver.findElement(By.xpath("//*[@id='hotels']"));
		BaseClass.ddlb_Select(hotels, "value","Hotel Creek" );
		
		WebElement room_type = driver.findElement(By.xpath("//*[@id='room_type']"));
		BaseClass.ddlb_Select(room_type, "value", "Standard");
		
		WebElement room_nos = driver.findElement(By.xpath("//*[@id='room_nos']"));
		BaseClass.ddlb_Select(room_nos, "value", "2");
		
		WebElement check_in = driver.findElement(By.xpath("//*[@id='datepick_in']"));
		check_in.clear();
		BaseClass.inputdata(check_in, "19/11/2019");
		
		WebElement check_out = driver.findElement(By.xpath("//*[@id='datepick_out']"));
		check_out.clear();
		BaseClass.inputdata(check_out, "20/11/2019");
		
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id='Submit']"));
		BaseClass.clickButton(submitBtn);	
		
	//	BaseClass.screenshot("TC103");
		WebElement checklocation = driver.findElement(By.xpath("//*[@id='location_0']"));
		if (checklocation.getAttribute("value").equals("Melbourne")) {
			System.out.println("Melbourne");
		}
		WebElement indate_check = driver.findElement(By.xpath("//*[@id='arr_date_0']"));
		if (indate_check.getAttribute("value").equals("19/11/2019")) {
			System.out.println("19/11/2019");
		}
		WebElement outdate_check= driver.findElement(By.xpath("//*[@id='dep_date_0']"));
		if (outdate_check.getAttribute("value").equals("20/11/2019")) {
			System.out.println("20/11/2019");
		}
		WebElement noofrooms_check= driver.findElement(By.xpath("//*[@id='rooms_0']"));
		if (noofrooms_check.getAttribute("value").contains("1")) {
			System.out.println("13/11/2019");
		}
		
		WebElement roomtype_check= driver.findElement(By.xpath("//*[@id='room_type_0']"));
		if (roomtype_check.getAttribute("value").equals("Standard")) {
			System.out.println("standard");
		}
		
		WebElement totalprice_check= driver.findElement(By.xpath("//*[@id='total_price_0']"));
		if (totalprice_check.getAttribute("value").contains("250")) {
			System.out.println("total price 250");
		}
		else {
			System.out.println("invalid price");
		}
		
		BaseClass.screenshot("TC110");
	
		driver.findElement(By.partialLinkText("Logout")).click();
		//BaseClass.screenshot("TC109");
	}

}

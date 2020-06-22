package com.ddt.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException, NumberFormatException, IOException {
		String csvFile = "names.csv";
		BufferedReader br = null;
		String line = "";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the contact name:");
		String name = br.readLine();
		System.out.println("Enter the msg you want to send:");
		String msg = br.readLine();
		System.out.println("Enter the number of times you want to send the msg:");
		int count = Integer.parseInt(br.readLine());
		
		String baseUrl = "https://web.whatsapp.com/";

		driver.get(baseUrl);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//label[@class='_3xpD_']")).click();
		WebElement ser = driver.findElement(By.xpath("//div[@class='_3FRCZ copyable-text selectable-text']"));
		ser.sendKeys(name + "\n");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='" + name + "']")).click();
		while (count-- >= 0) 
		{
			WebElement e = driver.findElement(By.xpath("//div[@class='_3uMse']"));
			e.sendKeys(msg + " \n");
		}
		driver.close();

	}

}
package com.maven.terrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



import io.github.bonigarcia.wdm.WebDriverManager;



public class Example {

ExtentSparkReporter reporter;
ExtentReports extent;



@BeforeSuite
public void setUp() {
reporter = new ExtentSparkReporter("myreport.html");
extent = new ExtentReports();
extent.attachReporter(reporter);
}

@Test
public void TestMethod()
// to configure driver
{

ExtentTest test = extent.createTest("My first test");
test.log(Status.INFO, "This shows info");

System.setProperty("webdriver.chrome.driver","C:/Users/harshithag/eclipse-workspace_SeleniumTraining/SeleniumProject/drivers/chromedriver.exe");
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://www.google.com/");
driver.manage().window().maximize(); //method used to open URL and it will maximize
//Thread.sleep(5000); // let the user actually see something!
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("ChromeDriver");
searchBox.submit();
//Thread.sleep(5000); // let the user actually see something!
driver.quit();
}
}



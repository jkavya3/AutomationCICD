package FrameWorkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameWorkDesign.PageObjectClasses.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage; 
	
	  public WebDriver InitializeDriver() throws IOException {
		  
		  //properties class
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//FrameWorkDesign//resources//GlobalData.properties");
		  prop.load(fis);		  
		  String browserName = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		  
		  if(browserName.contains("chrome"))
		  {
		     ChromeOptions options = new ChromeOptions(); 
		     if(browserName.contains("headless")) {
		      options.addArguments("headless");
		     }
		     driver = new ChromeDriver(options);
		     driver.manage().window().setSize(new Dimension(1440,900));
		  }
		 else if(browserName.equalsIgnoreCase("firefox"))
		  {
		
			 //driver = new GeckoDriver();
		
		  }
		else if(browserName.contains("edge"))
		  {
		    EdgeOptions options = new EdgeOptions();  
		    if(browserName.contains("headless")) {
		    	options.addArguments("--headless=new");
		    }
		   
			driver = new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		  }
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		  driver.manage().window().maximize();
		  return driver;
	}
	  
	  public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException {
			
			//read json to string
		String jsonContent = 	FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
			
			//String to HashMap Jackson Databind
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> (){
			});
			return data;
		}
	  public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source,file);
			return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";
		}
	  
	  @BeforeMethod(alwaysRun=true)
	  public LandingPage LaunchApplication() throws IOException
	  {
		 driver =  InitializeDriver();
		 landingpage = new LandingPage (driver);
		landingpage.goTo();
		return landingpage;
	  }
	  
	  @AfterMethod(alwaysRun=true)
	  
	  public void teardown() {
		  driver.quit();
	  }

}

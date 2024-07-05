package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	

public static WebDriver driver;
public Logger logger;
public Properties p;

@Parameters({"os","browser"})
	
	@BeforeClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	public void setup(String os, String br) throws IOException
	{
		
		logger =  LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader("C:\\Users\\KOTESM\\eclipse-workspace\\OpenCartProject\\src\\test\\resources\\config.properties");
	
		p = new Properties();
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("window"))
			{
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching in OS");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			default: System.out.println("No matching browser"); return;
			
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
		
		else if (p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver();break;
		default : System.out.println("There is no browser for testing");
		return;
		
		}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("addURL"));
		driver.manage().window().maximize();
	}
	public String randomeString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomInteger()
	{
		String generateTel = RandomStringUtils.randomNumeric(10);
		return generateTel;
	}
	
	
	public String randomAlphaNumeric()
	{
		String generatepass = RandomStringUtils.randomAlphabetic(4);
		String generateTel = RandomStringUtils.randomNumeric(10);
		return (generatepass+"@"+generateTel);
	}
	
	@AfterClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	public void setDown()
	{
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}

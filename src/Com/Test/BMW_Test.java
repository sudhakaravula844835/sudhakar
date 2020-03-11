package Com.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.WrapperClass;
import Com.page.BMW_page;

public class BMW_Test extends BaseClass.WrapperClass {

	@BeforeMethod
	public void startup() {
		launchApplication("chrome","https://www.bmw.in/en/index.html");
	}
	@Test
	public void test() throws IOException ,InterruptedException{
		BMW_page bmw=new BMW_page(driver);
		bmw.bmwpage();
	}
	@AfterMethod
	public void close() throws IOException{
		screenshot("C:\\Users\\BLTuser.BLT1036\\eclipse-workspace\\BMW\\screenshot\\bmw.png");
		quit();
	}
}
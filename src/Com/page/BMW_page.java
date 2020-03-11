package Com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BMW_page {
	
	WebDriver driver;
	
	By model=By.xpath("//a[contains(text(),'Models')]");
	By seven=By.xpath("//div[@class='tab-item tw-w-full tw-pb-300 tw-pl-500 tw-pr-500 xl:tw-pl-700 xl:tw-pr-700']//div//a[@class='tw-relative tw-overflow-hidden tw-pl-400 tw-pr-400 tw-m-0 tw-flex tw-items-center tw-font-bmw-bold tw-text-450 tw-text-grey-500 tw-border-b-400 tw-border-transparent hover:tw-text-grey-500 lg:hover:tw-border-b-400 lg:hover:tw-border-primary-500 lg:hover:tw-text-grey-900'][contains(text(),'7')]");
	By image=By.xpath("//div[contains(@class,'enhanced-model-card tw-relative tw-p-300 tw-mb-200 tw-mt-200 tw-relative tw-bg-white hover-out enhanced-model-card-small')]");
	//By technical=By.xpath("//a[contains(@class,'tw-font-bmw-bold tw-text-450 tw-no-underline tw-m-0 focus:tw-text-grey-500 tw-text-grey-500')][contains(text(),'Technical Data')]");
	
  public BMW_page(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void bmwpage() throws InterruptedException {
	  driver.findElement(model).click();
	  driver.findElement(seven).click();
	  driver.findElement(image).click();
	  Actions action=new Actions(driver);
	  action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'cta-button-content tw-h-600 tw-flex tw-relative tw-items-center tw-justify-center tw-whitespace-no-wrap')]"))).click().build().perform();
	  driver.findElement(By.linkText("Technical Data")).click();
	  String s=driver.findElement(By.xpath("//section[contains(@class,'content ds2-technical-data--content ds2-mvc-tabs-content__panel ds2-mvc-tabs-content__panel--active')]//div[contains(@class,'row')]//div[1]//div[1]//table[1]//tbody[1]//tr[4]//td[2]")).getText();
	  System.out.println(s);
	  String a=s.substring(5,8);
	  int n=Integer.parseInt(a);
	  if(n<500) {
		  System.out.println("pass");
		  
	  }
	  else{
		  System.out.println("fail");

	  }
  }
}
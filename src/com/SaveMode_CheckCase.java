package com.txy.ofn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SaveMode_CheckCase {
	  private WebDriver driver;
	  private String baseUrl;

	  @BeforeMethod
	  public void setUp() throws Exception {
	//  driver = new InternetExplorerDriver();  //IE浏览器
    //  diver = new FirefoxDriver(); //初始化一个火狐浏览器
	//  diver = new ChromeDriver(); //初始化一个chrome浏览器
		//当火狐不是默认安装的时候需要指定下火狐的安装驱动
		System.setProperty("webdriver.firefox.bin","F:\\常用软件\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //隐式等待
	    driver.manage().window().maximize();//浏览器窗口最大化
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();//浏览器窗口最大化
	    WebElement w_username = driver.findElement(By.id("userId")); //用户名
	    w_username.sendKeys("18310246224");
	    Thread.sleep(3000);
	    WebElement w_password = driver.findElement(By.name("password")); //密码
	    w_password.sendKeys("123456");
	    Thread.sleep(3000);
	    WebElement w_login = driver.findElement(By.className("landing"));   //登录
	    w_login.click();
	    Thread.sleep(3000);
	    
	    
	    //定位"信息管理"选项卡(鼠标悬停)
//	    WebElement w_infoManage = driver.findElement(By.className("clearfix"));//定位父元素
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//*[text()='信息管理']"))).perform();
	    Thread.sleep(3000);
	    //定位"评估模板管理"
	    WebElement w_modelManage = driver.findElement(By.xpath("//*[text()='评估模板管理']"));
	    w_modelManage.click();
	    Thread.sleep(3000);
	    /**
	     * case2:查看模板(随机查看)：定位页面上所有的元素
	     */
	    //定位页面上的所有"查看"
	    List<WebElement> linktexts = driver.findElements(By.className("asLook"));
//	    int size = linktexts.size();
//	    System.err.println("查看的个数："+size);
	    int n = (int)(Math.random()*linktexts.size()+1);  //随机生成第一页元素"查看"的个数(生成的随机数去掉0，否则定位不到)
	    System.out.println("n:"+n);
	    WebElement modelname_element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[2]"));
	    WebElement check_element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[7]/span[1]"));
	    check_element.click(); 
	    Thread.sleep(3000);
    	//断言：
    	WebElement modelname=driver.findElement(By.id("templateName"));
    	if(modelname.equals(modelname_element)){
    		return;
    	}
    	
//    	WebElement close_button=driver.findElement(By.className("clear mr20 closeBtn closeLook curPointer"));--这样定位报错
    	WebElement close_button=driver.findElement(By.className("curPointer")); //点击关闭按钮
    	close_button.click();
    	Thread.sleep(3000);
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
}

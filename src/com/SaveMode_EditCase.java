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

public class SaveMode_EditCase {
	  private WebDriver driver;
	  private String baseUrl;

	  @BeforeMethod
	  public void setUp() throws Exception {
	//  driver = new InternetExplorerDriver();  //IE浏览器
		//当火狐不是默认安装的时候需要指定下火狐的安装驱动
		System.setProperty("webdriver.firefox.bin","F:\\常用软件\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();//浏览器窗口最大化
	    WebElement w_username = driver.findElement(By.id("userId")); //用户名
	    w_username.sendKeys("18310246224");
	    Thread.sleep(3000); //线程停止3秒
	    WebElement w_password = driver.findElement(By.name("password")); //密码
	    w_password.sendKeys("123456");
	    Thread.sleep(3000); //线程停止3秒
	    WebElement w_login = driver.findElement(By.className("landing"));   //登录
	    w_login.click();
	    Thread.sleep(3000); //线程停止3秒
	    
	    //定位"信息管理"选项卡(鼠标悬停)
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//*[text()='信息管理']"))).perform();
	    Thread.sleep(3000); //线程停止3秒
	    
	    //定位"评估模板管理"
	    WebElement w_modelManage = driver.findElement(By.xpath("//*[text()='评估模板管理']"));
	    w_modelManage.click();
	    Thread.sleep(3000); //线程停止3秒
	    /**
	     * case3:编辑模板(随机编辑)：定位页面上所有的元素
	     */
	    //随机定位页面上的所有"编辑"
//	    List<WebElement> linktexts = driver.findElements(By.className("asEdit"));
//	    int n=getMathRandom(linktexts);
//	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[7]/span[2]"));
	    
	    //定位模版名称为txy,编辑修改为txy1
//	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+1+"]/td[7]/span[2]"));
	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr/td[7]/span[2]"));
  	    element.click();
  	    
  	    //修改模版名称
  	    WebElement modelname = driver.findElement(By.id("nameInput"));
  	    modelname.clear();
  	    modelname.sendKeys("txytxy");
        Thread.sleep(3000);
  	    //点击保存
  	    WebElement save_name = driver.findElement(By.id("saveName"));
  	    save_name.click();
  	    Thread.sleep(3000);
  	    
  	    //点击"保存模版"按钮
  	    WebElement saveTemplate = driver.findElement(By.id("saveTemplate"));
  	    saveTemplate.click();
	  }
	  
	  //获得随机数 
	  public int getMathRandom(List<WebElement> linktexts){
		  int size = linktexts.size();
		  System.out.println("编辑的个数："+size);
		  int n = (int)(Math.random()*size+1);//随机生成第一页元素"编辑"的个数(生成的随机数去掉0，否则定位不到)
		  System.out.println("n:"+n);
		  return n;		  
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
}

package com.txy.ofn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SaveMode_CreateCase1 {
	  private WebDriver driver;
	  private String baseUrl;

	  @BeforeMethod
	  public void setUp() throws Exception {
	//  driver = new InternetExplorerDriver();  //IE浏览器
		//当火狐不是默认安装的时候需要指定下火狐的安装驱动
		System.setProperty("webdriver.firefox.bin","F:\\常用软件\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //隐式等待
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
	    //(断言：页面出现"当前位置：首页>信息管理>评估模板管理"时为真)
	    
	    /**
	     * case1:创建模板(创建之前先判断是否已经存在要创建的模板，若已经存在则不允许新建)
	     */
	    //先定位一个
	    By model_name=By.xpath("//*[text()='txy']");
	    if(getWebElementExist(driver,model_name)==true){
	    	//新建之前删掉重名的模板
	    	WebElement w_delete = driver.findElement(By.className("asDelete"));
	    	w_delete.click();
	    	Thread.sleep(3000);
	    	
	    	//确认删除评估模板
	    	WebElement w_confirm = driver.findElement(By.id("delOk"));
	    	w_confirm.click();
	    	Thread.sleep(3000);
	    	createModel();
	    }else{
	    	createModel();
	    	Thread.sleep(3000);
	    }    
//	    getRandomType(); //随机指定机型
	    getSingleType(); //指定其中固定的一种机型

	    WebElement w_confirm = driver.findElement(By.id("ok"));
  	    w_confirm.click();
  	    //创建成功断言：页面该模板的状态为："未发布"  	    
//  	int n = 1;
//  	WebElement state = driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[6]"));
  	    String state = driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr[1]/td[6]")).getText();
  	    if(state.equals("未发布")){
  	    	Assert.assertTrue(true);
  	    } 	    	
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
	  
	  public void getRandomType(){ //随机定位其中一种机型
		  int n = (int)(Math.random()*635+1);  //随机生成第一页元素"编辑"的个数(生成的随机数去掉0，否则定位不到)
		  System.out.println("n:"+n);
		  WebElement type =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/div/ul/li["+n+"]"));
	  	  type.click();
	  }
	  /**
	  public void getNumOfType(){ //得到机型的型号所有数量
		  List<WebElement> detList = driver.findElements(By.className("detList"));
		  System.out.println("detList大小："+detList.size());
		  int n = (int)(Math.random()*detList.size()+1);  //随机生成
		  System.out.println("n:"+n);
		  WebElement type =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/div/div[2]/p["+n+"]/img"));
	  	  type.click();
	  }
	 * @throws InterruptedException 
	  */
	  public void createModel() throws InterruptedException{
		    //定位"新建模板"
		    WebElement w_newModel = driver.findElement(By.id("newTemplate"));
		    w_newModel.click();	
		    Thread.sleep(3000);
		    
		    //录入模板名称
		    WebElement w_modelName = driver.findElement(By.id("nameInput"));
		    w_modelName.clear();
		    w_modelName.sendKeys("txy"); //输入模板名称
		    Thread.sleep(3000);
		    
		    WebElement w_saveButton = driver.findElement(By.id("saveName"));
		    w_saveButton.click();
		    Thread.sleep(3000);
	  }
	  
	  public boolean getWebElementExist(WebDriver driver,By selector){//判断是否有相同的模版名称
		  try{
			  driver.findElement(selector);
			  return true;
		  }catch(NoSuchElementException e){
		    return false;
		  }
	  }
	  
	  public void getSingleType() throws InterruptedException{ //指定其中的一种机型
		    //设置涵盖机制
		    WebElement w_zhongxing = driver.findElement(By.xpath("//*[text()='中兴']"));
		    w_zhongxing.click();   //选择"中兴"
		    Thread.sleep(3000);
		    
		    WebElement w_checkbox4 = driver.findElement(By.id("3770")).findElement(By.tagName("img"));
		    w_checkbox4.click();  //选择N760
		    Thread.sleep(3000);
		    
		    WebElement w_typeBtnBox = driver.findElement(By.id("typeOk"));
		    w_typeBtnBox.click();  //点击"确认已选机型"
		    Thread.sleep(3000);
		    
		    //设置评估参数(拖动参数)
//		    List<WebElement> elements = driver.findElements(By.className("problemName"));
//		    System.out.println("elements="+elements.size());  //elements=74
		    WebElement element1 = driver.findElement(By.xpath("//*[text()='购买渠道']")); //定义第一个元素
		    WebElement target1 =driver.findElement(By.id("detailList"));   //定义第二个元素
		    (new Actions(driver)).dragAndDrop(element1, target1).perform();  //将第一个元素拖拽到第二个元素
		    Thread.sleep(3000);
		    
		    WebElement element2 = driver.findElement(By.xpath("//*[text()='颜色']")); //定义第一个元素
		    WebElement target2 =driver.findElement(By.id("detailList"));   //定义第二个元素
		    (new Actions(driver)).dragAndDrop(element2, target2).perform();  //将第一个元素拖拽到第二个元素
		    Thread.sleep(3000);
		    
		    //saveTemplate  点击"保存模板"
		    WebElement saveTemplate = driver.findElement(By.id("saveTemplate"));
		    saveTemplate.click();
		    Thread.sleep(3000);
	  }
}

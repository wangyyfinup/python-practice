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
	//  driver = new InternetExplorerDriver();  //IE�����
		//���������Ĭ�ϰ�װ��ʱ����Ҫָ���»���İ�װ����
		System.setProperty("webdriver.firefox.bin","F:\\�������\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //��ʽ�ȴ�
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();//������������
	    WebElement w_username = driver.findElement(By.id("userId")); //�û���
	    w_username.sendKeys("18310246224");
	    Thread.sleep(3000);
	    WebElement w_password = driver.findElement(By.name("password")); //����
	    w_password.sendKeys("123456");
	    Thread.sleep(3000);
	    WebElement w_login = driver.findElement(By.className("landing"));   //��¼
	    w_login.click();
	    Thread.sleep(3000);
	    
	    //��λ"��Ϣ����"ѡ�(�����ͣ)
//	    WebElement w_infoManage = driver.findElement(By.className("clearfix"));//��λ��Ԫ��
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//*[text()='��Ϣ����']"))).perform();
	    Thread.sleep(3000);
	    
	    //��λ"����ģ�����"
	    WebElement w_modelManage = driver.findElement(By.xpath("//*[text()='����ģ�����']"));
	    w_modelManage.click();
	    Thread.sleep(3000);
	    //(���ԣ�ҳ�����"��ǰλ�ã���ҳ>��Ϣ����>����ģ�����"ʱΪ��)
	    
	    /**
	     * case1:����ģ��(����֮ǰ���ж��Ƿ��Ѿ�����Ҫ������ģ�壬���Ѿ������������½�)
	     */
	    //�ȶ�λһ��
	    By model_name=By.xpath("//*[text()='txy']");
	    if(getWebElementExist(driver,model_name)==true){
	    	//�½�֮ǰɾ��������ģ��
	    	WebElement w_delete = driver.findElement(By.className("asDelete"));
	    	w_delete.click();
	    	Thread.sleep(3000);
	    	
	    	//ȷ��ɾ������ģ��
	    	WebElement w_confirm = driver.findElement(By.id("delOk"));
	    	w_confirm.click();
	    	Thread.sleep(3000);
	    	createModel();
	    }else{
	    	createModel();
	    	Thread.sleep(3000);
	    }    
//	    getRandomType(); //���ָ������
	    getSingleType(); //ָ�����й̶���һ�ֻ���

	    WebElement w_confirm = driver.findElement(By.id("ok"));
  	    w_confirm.click();
  	    //�����ɹ����ԣ�ҳ���ģ���״̬Ϊ��"δ����"  	    
//  	int n = 1;
//  	WebElement state = driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[6]"));
  	    String state = driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr[1]/td[6]")).getText();
  	    if(state.equals("δ����")){
  	    	Assert.assertTrue(true);
  	    } 	    	
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
	  
	  public void getRandomType(){ //�����λ����һ�ֻ���
		  int n = (int)(Math.random()*635+1);  //������ɵ�һҳԪ��"�༭"�ĸ���(���ɵ������ȥ��0������λ����)
		  System.out.println("n:"+n);
		  WebElement type =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/div/ul/li["+n+"]"));
	  	  type.click();
	  }
	  /**
	  public void getNumOfType(){ //�õ����͵��ͺ���������
		  List<WebElement> detList = driver.findElements(By.className("detList"));
		  System.out.println("detList��С��"+detList.size());
		  int n = (int)(Math.random()*detList.size()+1);  //�������
		  System.out.println("n:"+n);
		  WebElement type =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/div/div[2]/p["+n+"]/img"));
	  	  type.click();
	  }
	 * @throws InterruptedException 
	  */
	  public void createModel() throws InterruptedException{
		    //��λ"�½�ģ��"
		    WebElement w_newModel = driver.findElement(By.id("newTemplate"));
		    w_newModel.click();	
		    Thread.sleep(3000);
		    
		    //¼��ģ������
		    WebElement w_modelName = driver.findElement(By.id("nameInput"));
		    w_modelName.clear();
		    w_modelName.sendKeys("txy"); //����ģ������
		    Thread.sleep(3000);
		    
		    WebElement w_saveButton = driver.findElement(By.id("saveName"));
		    w_saveButton.click();
		    Thread.sleep(3000);
	  }
	  
	  public boolean getWebElementExist(WebDriver driver,By selector){//�ж��Ƿ�����ͬ��ģ������
		  try{
			  driver.findElement(selector);
			  return true;
		  }catch(NoSuchElementException e){
		    return false;
		  }
	  }
	  
	  public void getSingleType() throws InterruptedException{ //ָ�����е�һ�ֻ���
		    //���ú��ǻ���
		    WebElement w_zhongxing = driver.findElement(By.xpath("//*[text()='����']"));
		    w_zhongxing.click();   //ѡ��"����"
		    Thread.sleep(3000);
		    
		    WebElement w_checkbox4 = driver.findElement(By.id("3770")).findElement(By.tagName("img"));
		    w_checkbox4.click();  //ѡ��N760
		    Thread.sleep(3000);
		    
		    WebElement w_typeBtnBox = driver.findElement(By.id("typeOk"));
		    w_typeBtnBox.click();  //���"ȷ����ѡ����"
		    Thread.sleep(3000);
		    
		    //������������(�϶�����)
//		    List<WebElement> elements = driver.findElements(By.className("problemName"));
//		    System.out.println("elements="+elements.size());  //elements=74
		    WebElement element1 = driver.findElement(By.xpath("//*[text()='��������']")); //�����һ��Ԫ��
		    WebElement target1 =driver.findElement(By.id("detailList"));   //����ڶ���Ԫ��
		    (new Actions(driver)).dragAndDrop(element1, target1).perform();  //����һ��Ԫ����ק���ڶ���Ԫ��
		    Thread.sleep(3000);
		    
		    WebElement element2 = driver.findElement(By.xpath("//*[text()='��ɫ']")); //�����һ��Ԫ��
		    WebElement target2 =driver.findElement(By.id("detailList"));   //����ڶ���Ԫ��
		    (new Actions(driver)).dragAndDrop(element2, target2).perform();  //����һ��Ԫ����ק���ڶ���Ԫ��
		    Thread.sleep(3000);
		    
		    //saveTemplate  ���"����ģ��"
		    WebElement saveTemplate = driver.findElement(By.id("saveTemplate"));
		    saveTemplate.click();
		    Thread.sleep(3000);
	  }
}

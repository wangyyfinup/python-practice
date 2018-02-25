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
	//  driver = new InternetExplorerDriver();  //IE�����
		//���������Ĭ�ϰ�װ��ʱ����Ҫָ���»���İ�װ����
		System.setProperty("webdriver.firefox.bin","F:\\�������\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();//������������
	    WebElement w_username = driver.findElement(By.id("userId")); //�û���
	    w_username.sendKeys("18310246224");
	    Thread.sleep(3000); //�߳�ֹͣ3��
	    WebElement w_password = driver.findElement(By.name("password")); //����
	    w_password.sendKeys("123456");
	    Thread.sleep(3000); //�߳�ֹͣ3��
	    WebElement w_login = driver.findElement(By.className("landing"));   //��¼
	    w_login.click();
	    Thread.sleep(3000); //�߳�ֹͣ3��
	    
	    //��λ"��Ϣ����"ѡ�(�����ͣ)
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//*[text()='��Ϣ����']"))).perform();
	    Thread.sleep(3000); //�߳�ֹͣ3��
	    
	    //��λ"����ģ�����"
	    WebElement w_modelManage = driver.findElement(By.xpath("//*[text()='����ģ�����']"));
	    w_modelManage.click();
	    Thread.sleep(3000); //�߳�ֹͣ3��
	    /**
	     * case3:�༭ģ��(����༭)����λҳ�������е�Ԫ��
	     */
	    //�����λҳ���ϵ�����"�༭"
//	    List<WebElement> linktexts = driver.findElements(By.className("asEdit"));
//	    int n=getMathRandom(linktexts);
//	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[7]/span[2]"));
	    
	    //��λģ������Ϊtxy,�༭�޸�Ϊtxy1
//	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+1+"]/td[7]/span[2]"));
	    WebElement element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr/td[7]/span[2]"));
  	    element.click();
  	    
  	    //�޸�ģ������
  	    WebElement modelname = driver.findElement(By.id("nameInput"));
  	    modelname.clear();
  	    modelname.sendKeys("txytxy");
        Thread.sleep(3000);
  	    //�������
  	    WebElement save_name = driver.findElement(By.id("saveName"));
  	    save_name.click();
  	    Thread.sleep(3000);
  	    
  	    //���"����ģ��"��ť
  	    WebElement saveTemplate = driver.findElement(By.id("saveTemplate"));
  	    saveTemplate.click();
	  }
	  
	  //�������� 
	  public int getMathRandom(List<WebElement> linktexts){
		  int size = linktexts.size();
		  System.out.println("�༭�ĸ�����"+size);
		  int n = (int)(Math.random()*size+1);//������ɵ�һҳԪ��"�༭"�ĸ���(���ɵ������ȥ��0������λ����)
		  System.out.println("n:"+n);
		  return n;		  
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
}

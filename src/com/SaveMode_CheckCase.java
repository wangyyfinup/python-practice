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
	//  driver = new InternetExplorerDriver();  //IE�����
    //  diver = new FirefoxDriver(); //��ʼ��һ����������
	//  diver = new ChromeDriver(); //��ʼ��һ��chrome�����
		//���������Ĭ�ϰ�װ��ʱ����Ҫָ���»���İ�װ����
		System.setProperty("webdriver.firefox.bin","F:\\�������\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://218.206.81.94/ofns-cms/login.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //��ʽ�ȴ�
	    driver.manage().window().maximize();//������������
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
	    /**
	     * case2:�鿴ģ��(����鿴)����λҳ�������е�Ԫ��
	     */
	    //��λҳ���ϵ�����"�鿴"
	    List<WebElement> linktexts = driver.findElements(By.className("asLook"));
//	    int size = linktexts.size();
//	    System.err.println("�鿴�ĸ�����"+size);
	    int n = (int)(Math.random()*linktexts.size()+1);  //������ɵ�һҳԪ��"�鿴"�ĸ���(���ɵ������ȥ��0������λ����)
	    System.out.println("n:"+n);
	    WebElement modelname_element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[2]"));
	    WebElement check_element =driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr["+n+"]/td[7]/span[1]"));
	    check_element.click(); 
	    Thread.sleep(3000);
    	//���ԣ�
    	WebElement modelname=driver.findElement(By.id("templateName"));
    	if(modelname.equals(modelname_element)){
    		return;
    	}
    	
//    	WebElement close_button=driver.findElement(By.className("clear mr20 closeBtn closeLook curPointer"));--������λ����
    	WebElement close_button=driver.findElement(By.className("curPointer")); //����رհ�ť
    	close_button.click();
    	Thread.sleep(3000);
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	  }
}

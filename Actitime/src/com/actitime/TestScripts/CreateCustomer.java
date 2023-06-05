package com.actitime.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.GenericLibrary.BaseClass;
import com.actitime.GenericLibrary.FileLibrary;
import com.actitime.ObjectRepository.Taskpage;

public class CreateCustomer extends BaseClass {
	
	@Test
	public void createcustomer() { 
		HomePage hp=new HomePage(driver);
		hp.getTaskLab().click();
		Taskpage tp=new Taskpage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary fl=new FileLibrary();
		String customer = fl.readdataFromExcel("Excel",3,1);
		tp.getCustname().sendKeys(customer);
		fl.readdataFromExcel("Excel",3,2);
		tp.getCustdesp().sendKeys(description);
		tp.getCreatebtn().click();
		String expectedresult=customer;
		String actualresult = driver.findElement(By.xpath("(//div[.='Salman Khan'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
	}

}

package com.orangehrm.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generics.Baseclass;
import com.orangehrm.generics.FileLib;
import com.orangehrm.generics.WebDrivercommonLib;
import com.orangehrm.objectrepository.Adminpage;

@Listeners(com.orangehrm.generics.ListenersImplementation.class)
public class demo extends Baseclass {
	@Test
	public void testlogin() throws EncryptedDocumentException,InterruptedException, IOException{
		Reporter.log("Edit organization",true);
		FileLib fileLib = new FileLib();
		String oranizationame = fileLib.getExcelvalue("Sheet1", 1, 0);
		
		String email = fileLib.getExcelvalue("Sheet1", 1, 1);		
		
		Adminpage ap=new Adminpage(driver);
		
		
		//Actions a= new Actions(driver);
		WebDrivercommonLib w= new WebDrivercommonLib();
		
		w.mouseHoverAction(driver,ap.getAdmindropdoWebElement());
    	ap.getAdmindropdoWebElement().click();
		w.mouseHoverAction(driver, ap.getOrganizationElement());
	    //a.moveToElement(ap.getAdmindropdoWebElement()).perform();
		//a.moveToElement(ap.getOrganizationElement()).perform();
		ap.getGeneralinformationoption().click();
		ap.getEditbtn().click();
		ap.getOrganizationNametbx().clear();
		ap.getOrganizationNametbx().sendKeys(oranizationame);
		ap.getOrganizationemailtbx().clear();
		ap.getOrganizationemailtbx().sendKeys(email);
		String Actualorganize = ap.getOrganizationNametbx().getAttribute("value");
		Assert.assertEquals(Actualorganize,oranizationame );
		
		
		
	}
	
}

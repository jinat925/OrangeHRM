package com.orangehrm.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generics.Baseclass;
import com.orangehrm.generics.WebDrivercommonLib;
import com.orangehrm.objectrepository.Performancepage;
@Listeners(com.orangehrm.generics.ListenersImplementation.class)
public class PerformTest extends Baseclass {
	@Test
	public void testperformance() {
		Reporter.log("Test performance module",true);
		WebDrivercommonLib w= new WebDrivercommonLib();
		Performancepage perform=new Performancepage(driver);
				w.mouseHoverAction(driver, perform.getPerformancedropdown());
				w.mouseHoverAction(driver,perform.getConfiguredropdown() );
	}

}

package com.meghabassi.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meghabassi.pages.LoginPage;
import com.meghabassi.utils.TestDataProvider;

import com.meghabassi.commonLibs.implementation.CommonDriver;
import  com.meghabassi.commonLibs.implementation.Interactions;

public class LoginPageTests {
 CommonDriver cmnDriver;
 String url="http://demo.guru99.com/v4";
 LoginPage loginPage;
 
 @BeforeMethod
 public void setup() throws Exception{
	cmnDriver=new CommonDriver("chrome");
	cmnDriver.navigateToFirstUrl(url);
	loginPage= new LoginPage(cmnDriver.getDriver());
	
 }
 


 @Test(dataProvider="getDataFromExcel",dataProviderClass= TestDataProvider.class)
 public void verifyLogin(String sUsername,String sPassword) throws Exception{

 //String sUsername="mngr546444";
 //String sPassword= "umujUtu";
 Thread.sleep(2000);
 loginPage.loginToApplication(sUsername,sPassword);
 String actualTitle=cmnDriver.getTitle();
 String expectedTitle= "Guru99 Bank Manager HomePage";
 Assert.assertEquals(actualTitle,expectedTitle);
 
 }
 
 @AfterMethod
 public void cleanup() throws Exception{
	cmnDriver.closeAllBrowsers();
 }
 
}

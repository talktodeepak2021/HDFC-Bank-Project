package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
WebDriver ldriver;

public loginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(name="uid")
WebElement txtusername;

@FindBy(name="password")
WebElement txtpsswd;

@FindBy(name="btnLogin")
WebElement bttnlogin;

@FindBy(xpath="//a[normalize-space()='Log out']")
WebElement bttnlogout;


public void setusername(String username)
{
	txtusername.sendKeys(username);
}

public void setpassword(String Password)
{
	txtpsswd.sendKeys(Password);
}

public void clickLogin()
{
	bttnlogin.click();
}

public void clickLogout()
{
	bttnlogout.click();
}


}

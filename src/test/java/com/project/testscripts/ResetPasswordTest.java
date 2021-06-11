package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.LoginPage;
import com.project.pages.ResetPasswordPage;

public class ResetPasswordTest extends Base{
	ResetPasswordPage resetPassword;
	@Test
	public void verifyResetPageLoadedorNot() {
		LoginPage login = new LoginPage(driver);
		resetPassword = login.clickonForgotPassword();
		boolean result = resetPassword.isResetPageLoaded();
		Assert.assertTrue(result,"Reset Page not loaded");
	}
	
	@Test
	public void verifyForgotPasswordError()
	{
		LoginPage login = new LoginPage(driver);
		resetPassword = login.clickonForgotPassword();
		resetPassword.enterEmail("abcd@admin.com");
		resetPassword.clickOnResetButton();
		String actualmessage= resetPassword.getsuccessMessage();
		String expectedmessage= "We can't find a user with that e-mail address.";
		Assert.assertEquals(actualmessage, expectedmessage,"Reset password failed");
	}

}

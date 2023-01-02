package com.impactqa.page.mbxr;

import com.impactqa.page.mobile.BasePage;
import com.impactqa.utilities.PageObjectRepoHelper;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class GetComfortablePage extends BasePage {
    private static final String PageObjectRepoFileName = "GetComfortablePage.xml";

    public GetComfortablePage(AppiumDriver driver, PageObjectRepoHelper.PLATFORM platform) {
        super(driver, PageObjectRepoFileName, platform);
    }
    @Step("Get Comfortable screen")
    public boolean getComfortableMsgDisplayed()
    {
        return appiumUtils.isElementDisplayed("getComfortableScreen", 10);
    }
    @Step("Tap on Next button")
    public void tapOnNext()
    {
        appiumUtils.isElementDisplayed("next", 30);
        appiumUtils.click("next");
    }
}
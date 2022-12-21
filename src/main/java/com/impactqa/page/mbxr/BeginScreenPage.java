package com.impactqa.page.mbxr;

import com.impactqa.page.mobile.BasePage;
import com.impactqa.utilities.PageObjectRepoHelper;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class BeginScreenPage extends BasePage {
    private static final String PageObjectRepoFileName = "BeginScreenPage.xml";

    public BeginScreenPage(AppiumDriver driver, PageObjectRepoHelper.PLATFORM platform) {
        super(driver, PageObjectRepoFileName, platform);
    }

    @Step("Is Begin Screen Displayed")
    public boolean isBeginScreenDisplayed()
    {
        return appiumUtils.isElementDisplayed("begin", 100);
    }

    @Step("Welcome screen of MBXR")
    public boolean isWelcomeScreenDisplayed()
    {
        return appiumUtils.isElementDisplayed("welcomeScreen", 30);
    }
    @Step("Tap on Begin button")
    public void tapOnBegin()
    {
        appiumUtils.isElementDisplayed("begin", 30);
        appiumUtils.click("begin");
    }
}

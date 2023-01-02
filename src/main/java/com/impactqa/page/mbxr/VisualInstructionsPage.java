package com.impactqa.page.mbxr;

import com.impactqa.page.mobile.BasePage;
import com.impactqa.utilities.PageObjectRepoHelper;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class VisualInstructionsPage extends BasePage {
    private static final String PageObjectRepoFileName = "VisualInstructionsPage.xml";

    public VisualInstructionsPage(AppiumDriver driver, PageObjectRepoHelper.PLATFORM platform) {
        super(driver, PageObjectRepoFileName, platform);
    }
    @Step("Visual instructions screen")
    public boolean visualInstDisplayed()
    {
        return appiumUtils.isElementDisplayed("visualInstructions", 30);
    }
    @Step("Visual toggle label")
    public boolean visualToggleLabel()
    {
        return appiumUtils.isElementDisplayed("visualToggleLabel", 30);
    }

    @Step("Tap on Next button")
    public void tapOnNext()
    {
        appiumUtils.isElementDisplayed("next", 30);
        appiumUtils.click("next");
    }
}
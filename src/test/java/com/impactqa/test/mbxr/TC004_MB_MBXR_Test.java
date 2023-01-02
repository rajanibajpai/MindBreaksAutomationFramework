package com.impactqa.test.mbxr;


import com.impactqa.base.BaseTestMobile;
import com.impactqa.listeners.TestAllureListener;
import com.impactqa.page.mbxr.BeginScreenPage;
import com.impactqa.page.mbxr.GetComfortablePage;
import com.impactqa.page.mbxr.VisualInstructionsPage;
import com.impactqa.utilities.ExcelUtil;
import com.impactqa.utilities.FrameworkConfig;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Test Android or iOS")
@Feature("Test Android Execution")
@Listeners({TestAllureListener.class})
public class TC004_MB_MBXR_Test extends BaseTestMobile {

    @BeforeClass
    @Parameters({"dataID"})
    @Description("Read test data with testID {0}")
    public void getTestData(String dataID) {
        ExcelUtil excel = new ExcelUtil();
        excel.setWorkbook(FrameworkConfig.getStringConfigProperty("TestDataFileLocation"),
                FrameworkConfig.getStringConfigProperty("TestDataSheetName_mobile"));

        testDataMap = excel.getRowDataMatchingDataId(dataID);
        if (testDataMap.size() < 1)
            Assert.fail("dataID '" + dataID + "' is valid the excel sheet. please check the test data sheet");
    }

    @Test(priority = 1, description = "Launch APP")
    @Story("Launch APP")
    @Description("Verify APP Launch")
    public void verifyBeginScreen() {
        BeginScreenPage beginScreenPage = new BeginScreenPage(driver, platform);
        if(beginScreenPage.isBeginScreenDisplayed()){
            Allure.step("Pass");
        }else{
            Allure.step("Fail");
            Assert.fail("Fail");
        }
    }
    @Test(priority = 2, description = "Click Begin Button")
    @Story("Click Begin Button")
    @Description("Verify Begin Button")
    public void verifyBeginButton() {
        BeginScreenPage beginScreenPage = new BeginScreenPage(driver, platform);
        beginScreenPage.tapOnBegin();

    }

    @Test(priority = 3, description = "Click on Next Button")
    @Story("Click Next Button")
    @Description("Verify Next Button")
    public void verifyComfortNextButton() {
        GetComfortablePage getComfortablePage = new GetComfortablePage(driver, platform);
        getComfortablePage.tapOnNext();

    }

   @Test(priority = 4, description = "Visual instructions", dependsOnMethods = "verifyComfortNextButton")
   @Story("Get Visual instructions")
   @Description("Verify Visual instructions")
   public void visualInstructions() {
       VisualInstructionsPage visualInst = new VisualInstructionsPage(driver, platform);
       if(visualInst.visualInstDisplayed()){
           Allure.step("Pass");
       }else{
           Allure.step("Fail");
       }
   }

    @Test(priority = 5, description = "Visual toggle label", dependsOnMethods = "verifyComfortNextButton")
    @Story("Get visual toggle label")
    @Description("Verify visual toggle label")
    public void visualToggleLabel() {
        VisualInstructionsPage visualInst = new VisualInstructionsPage(driver, platform);
        if(visualInst.visualToggleLabel()){
            Allure.step("Pass");
            //Write code to click on toggle button here
        }else{
            Allure.step("Fail");
        }
    }

    @Test(priority = 6, description = "Click on Next Button", dependsOnMethods = "visualToggleLabel")
    @Story("Click Next Button")
    @Description("Verify Next Button on Visual instructions page")
    public void verifyVisualNextButton() {
        VisualInstructionsPage visualInstructions = new VisualInstructionsPage(driver, platform);
        visualInstructions.tapOnNext();

    }
}

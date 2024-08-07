package com.testCases;

import com.Models.Iqsoft003_BackendLoggedIn.Iqsoft_000_BasePage;
import com.pageObjects.Iqsoft_Page_01_Header;
import com.pageObjects.Iqsoft_001_BasePage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import java.io.File;
import java.time.Duration;


public class Iqsoft_001_BaseTest extends Iqsoft_000_BasePage {

    public Iqsoft_001_BaseTest() {
    }


    @BeforeSuite
    public void setupBeforeAll() throws InterruptedException {
        Iqsoft_001_BasePage.logger = Logger.getLogger("craftBet");
        PropertyConfigurator.configure("Log4j.properties");
        Iqsoft_001_BasePage.logger.info("<<<<<<<<<<<<<<<<<<<<<<<<< Test Suite Started  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
        Iqsoft_001_BasePage.logger.info("");

        String folderPathAllure = "./allure-results";
        String folderPathLogs = "./log/testlogs.log";
        File folderAllure = new File(folderPathAllure);
        if (folderAllure.exists()) {
            Iqsoft_001_BasePage.deleteFolder(folderAllure);
        }
        File folderLogs = new File(folderPathLogs);
        if (folderLogs.exists()) {
            Iqsoft_001_BasePage.deleteFolder(folderLogs);
        }

        loginRequest();
        getProductUrl();


        try {
            initDriver(gameUrl, browser, isHeadless);
//            DevTools devTools = ((HasDevTools) driver).getDevTools();
//            devTools.createSession();

            // Clear browser cache
//            Iqsoft_001_BasePage.clearBrowserCache(devTools);

            initElements();


            Dimension d = new Dimension(DimensionWidth, DimensionHeight);
            if (DimensionWidth > 1250 && DimensionHeight > 750) {

                driver.manage().window().setSize(d);
                Iqsoft_001_BasePage.logger.info("Window size is: " + DimensionWidth + " x " + DimensionHeight);
            }

        } catch (org.openqa.selenium.TimeoutException exception) {
            initDriver(gameUrl, browser, isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Iqsoft_000_BasePage.iqsoftPage01 = PageFactory.initElements(driver, Iqsoft_Page_01_Header.class);

    }

    @AfterSuite
    public void Finish() {
        if (driver != null) {
            driver.quit();
        }
        try {
            if (client!=null){
                client.closeBlocking();
                client.close();
            }
        } catch (InterruptedException e) {

        }
        Iqsoft_001_BasePage.logger.info("Browser closed");


        Iqsoft_001_BasePage.logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Test Suite finished  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
    }






}

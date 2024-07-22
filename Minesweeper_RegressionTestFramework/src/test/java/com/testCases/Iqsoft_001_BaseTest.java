package com.testCases;

import com.pageObjects.Iqsoft_Page_01;
import com.pageObjects.Iqsoft_001_BasePage;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.utilities.DriverFactory;
import com.utilities.ReadConfig;
import org.openqa.selenium.Dimension;

import java.io.File;
import java.time.Duration;


public class Iqsoft_001_BaseTest extends DriverFactory {

    Iqsoft_001_BasePage iqsoft001BasePage = new Iqsoft_001_BasePage();
    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getBaseURL();
    public String webSitWebApiURL = readConfig.getWebSitWebApi();
    public String isHeadless = readConfig.isHeadless();
    public String browser = readConfig.getBrowser();
    public String loginData = readConfig.getData();
    public int productId = readConfig.getProductId();
    public int DimensionHeight = readConfig.getDimensionHeight();
    public int DimensionWidth = readConfig.getDimensionWidth();

    public String loginPath = "LoginClient";
    public String getProductUrlPath = "GetProductUrl";
    public String token;
    public int clientId;
    public int partnerId;
    public String languageId;

    public String gameUrl;

    //region <Page Class Instances  >

    public Iqsoft_Page_01 iqsoftPage01;


    //endregion


    public Iqsoft_001_BaseTest() {
    }



    @BeforeSuite
    public void setupBeforeAll() {
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
            super.initDriver(gameUrl, browser, isHeadless);
            initElements();
            Dimension d = new Dimension(DimensionWidth, DimensionHeight);  //
            if (DimensionWidth > 1250 && DimensionHeight > 750) {

                driver.manage().window().setSize(d);
                Iqsoft_001_BasePage.logger.info("Window size is: " + DimensionWidth + " x " + DimensionHeight);
            }

        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(gameUrl, browser, isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        iqsoftPage01 = PageFactory.initElements(driver, Iqsoft_Page_01.class);

        Iqsoft_001_BasePage.logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Test Suite started ");
    }






    @AfterSuite
    public void Finish() {
        try {
            this.driver.quit();
            Iqsoft_001_BasePage.logger.info("Browser closed");
        } catch (Exception exception) {
            this.driver.quit();
            Iqsoft_001_BasePage.logger.info("Browser close_order has an exception");
        }

        Iqsoft_001_BasePage.logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Test Suite finished  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
    }









    public void loginRequest() {
        HttpResponse<String> response;
        int statusCode;
        String urlLoginApi = webSitWebApiURL + loginPath;


        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlLoginApi)
                .header("content-type", "application/json")
                .header("Origin", baseURL)
                .body("{\"Data\":\"" + loginData + "\"}")
                .asString();
        Unirest.shutDown();

        statusCode = response.getStatus();

        if (statusCode == 200) {

            String responseString = response.getBody();
            Unirest.shutDown();
            JSONObject responseJson = new JSONObject(responseString);
            int responseCode = Integer.parseInt(String.valueOf(responseJson.get("ResponseCode")));

            if (responseCode == 0) {
                clientId = Integer.parseInt(String.valueOf(responseJson.get("Id")));
                partnerId = Integer.parseInt(String.valueOf(responseJson.get("PartnerId")));
                languageId = String.valueOf(responseJson.get("LanguageId"));
                token = String.valueOf(responseJson.get("Token"));
            } else {
                throw new SkipException("GetProductUrl Response failed");
            }
        } else {
            throw new SkipException("GetProductUrl Request failed");
        }
    }


    public void getProductUrl() {
        HttpResponse<String> response;
        int statusCode;
        String urlGetProductUrlApi = webSitWebApiURL + getProductUrlPath;
        Unirest.config().reset();
        Unirest.config().connectTimeout(60000);
        Unirest.config().socketTimeout(60000);
        response = Unirest.post(urlGetProductUrlApi)
                .header("Content-Type", "application/json")
                .header("Origin", baseURL)
                .body("{\"IsForMobile\": false, \"LanguageId\": \"" + languageId + "\", \"PartnerId\":" + partnerId + ",\"ProductId\": " + productId +
                        ",\"TimeZone\": 4, " + "\"Token\": \"" + token + "\",\"ClientId\":" + clientId + ", \"IsForDemo\": false, \"IsAgent\": false}")
                .asString();

        statusCode = response.getStatus();
        if (statusCode == 200) {

            String responseString = response.getBody();
            Unirest.shutDown();
            JSONObject responseJson = new JSONObject(responseString);
            int responseCode = Integer.parseInt(String.valueOf(responseJson.get("ResponseCode")));
            if (responseCode == 0) {
                gameUrl = String.valueOf(responseJson.get("ResponseObject"));

                System.out.println(gameUrl);
            } else {
                throw new SkipException("GetProductUrl Response failed");
            }

        } else {
            throw new SkipException("GetProductUrl Request failed");

        }
    }

    public void initElements() {
      try{
        iqsoftPage01 = PageFactory.initElements(driver, Iqsoft_Page_01.class);
          System.out.println();
      }
      catch (Exception e){

          System.out.println();
      }
    }



}

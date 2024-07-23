package com.utilities;

import com.pageObjects.Iqsoft_001_BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {
    public static WebDriver driver;
    public static ChromeOptions cOptions;
    public static FirefoxOptions fOptions;
    public static EdgeOptions eOptions;

    public DriverFactory() {

    }

    public void initDriver(String siteUrl,String browser, String isHeadless) {
        switch (browser) {
            case "chrome":
                Iqsoft_001_BasePage.logger.info("Browser for test will be chrome as chosen");
                WebDriverManager.chromedriver().setup();
                cOptions=new ChromeOptions();
                if (isHeadless.equals("true")){
                    cOptions.addArguments("--headless", "--window-size=1920,1080");
//                    cOptions.setHeadless(true);
                    cOptions.setAcceptInsecureCerts(true);

                    cOptions.addArguments("--disable-web-security");
                    cOptions.addArguments("--ignore-certificate-errors");
                    cOptions.addArguments("--allow-running-insecure-content");
                    cOptions.addArguments("--no-sandbox");
                    cOptions.addArguments("--disable-dev-shm-usage");
                    cOptions.addArguments("--remote-allow-origins=*");
                    driver= new ChromeDriver(cOptions);
                }
                else{
                    cOptions.setAcceptInsecureCerts(true);

                    cOptions.addArguments("--disable-web-security");
                    cOptions.addArguments("--ignore-certificate-errors");
                    cOptions.addArguments("--allow-running-insecure-content");
                    cOptions.addArguments("--no-sandbox");
                    cOptions.addArguments("--disable-dev-shm-usage");
                    cOptions.addArguments("--remote-allow-origins=*");

                    driver = new ChromeDriver(cOptions);
                }
                break;

            case "firefox":
                Iqsoft_001_BasePage.logger.info("Browser for test will be firefox as chosen");
                WebDriverManager.firefoxdriver().setup();
                if (isHeadless.equals("true")){
                    fOptions=new FirefoxOptions();
                    fOptions.addArguments("--headless", "--window-size=1920,1080");
                    fOptions.setAcceptInsecureCerts(true);

                    fOptions.addArguments("--disable-web-security");
                    fOptions.addArguments("--ignore-certificate-errors");
                    fOptions.addArguments("--allow-running-insecure-content");
                    fOptions.addArguments("--no-sandbox");
                    fOptions.addArguments("--disable-dev-shm-usage");
                    fOptions.addArguments("--remote-allow-origins=*");
//                    fOptions.setHeadless(true);
                    driver= new FirefoxDriver(fOptions);
                }
                else{
                    fOptions.setAcceptInsecureCerts(true);

                    fOptions.addArguments("--disable-web-security");
                    fOptions.addArguments("--ignore-certificate-errors");
                    fOptions.addArguments("--allow-running-insecure-content");
                    fOptions.addArguments("--no-sandbox");
                    fOptions.addArguments("--disable-dev-shm-usage");
                    fOptions.addArguments("--remote-allow-origins=*");
                    driver = new FirefoxDriver();
                }
                break;


            case "edge":
                Iqsoft_001_BasePage.logger.info("Browser for test will be edge as chosen");
                WebDriverManager.edgedriver().setup();
                eOptions=new EdgeOptions();
                if (isHeadless.equals("true")){
                    eOptions.addArguments("--headless", "--window-size=1920,1080");
                    eOptions.setAcceptInsecureCerts(true);

                    eOptions.addArguments("--disable-web-security");
                    eOptions.addArguments("--ignore-certificate-errors");
                    eOptions.addArguments("--allow-running-insecure-content");
                    eOptions.addArguments("--no-sandbox");
                    eOptions.addArguments("--disable-dev-shm-usage");
                    eOptions.addArguments("--remote-allow-origins=*");
//                    eOptions.setHeadless(true);
                    driver= new EdgeDriver(eOptions);
                }
                else{
                    eOptions.setAcceptInsecureCerts(true);
                    eOptions.addArguments("--disable-web-security");
                    eOptions.addArguments("--ignore-certificate-errors");
                    eOptions.addArguments("--allow-running-insecure-content");
                    eOptions.addArguments("--no-sandbox");
                    eOptions.addArguments("--disable-dev-shm-usage");
                    eOptions.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(eOptions);
                }
                break;


            default:
                Iqsoft_001_BasePage.logger.info("Browser for test will be chrome by default");
                WebDriverManager.chromedriver().setup();
                if (isHeadless.equals("true")){
                    cOptions=new ChromeOptions();
                    eOptions.addArguments("--headless", "--window-size=1920,1080");
                    cOptions.addArguments("--disable-web-security");
                    cOptions.addArguments("--ignore-certificate-errors");
                    cOptions.addArguments("--allow-running-insecure-content");
                    cOptions.addArguments("--no-sandbox");
                    cOptions.addArguments("--disable-dev-shm-usage");
                    cOptions.addArguments("--remote-allow-origins=*");
//                    cOptions.setHeadless(true);
                    driver= new ChromeDriver(cOptions);
                }
                else{
                    driver = new ChromeDriver();
                }
        }
        driver.manage().window().maximize();
        driver.get(siteUrl);
    }

}


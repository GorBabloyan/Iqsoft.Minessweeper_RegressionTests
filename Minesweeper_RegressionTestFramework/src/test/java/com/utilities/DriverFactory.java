package com.utilities;

import com.pageObjects.Iqsoft_001_BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    public static WebDriver driver = null;
    public static ChromeOptions cOptions;
    public static FirefoxOptions fOptions;
    public static EdgeOptions eOptions;
    public static String webSocketUrl;
    public DriverFactory() {

    }
//    public BrowserMobProxy proxy = new BrowserMobProxyServer();

    public void initDriver(String siteUrl,String browser, String isHeadless) throws InterruptedException {
//        proxy.start(0);
//
//        // Get the Selenium proxy object
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);




        DevTools devTools = null;


        switch (browser) {
            // Start the BrowserMob proxy


            case "chrome":
                Iqsoft_001_BasePage.logger.info("Browser for test will be chrome as chosen");
                WebDriverManager.chromedriver().setup();
                cOptions=new ChromeOptions();
//                cOptions.setProxy(seleniumProxy);
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
                }
                else{
                    cOptions.setAcceptInsecureCerts(true);
//                    cOptions.setProxy(seleniumProxy);
                    cOptions.addArguments("--disable-web-security");
                    cOptions.addArguments("--ignore-certificate-errors");
                    cOptions.addArguments("--allow-running-insecure-content");
                    cOptions.addArguments("--no-sandbox");
                    cOptions.addArguments("--disable-dev-shm-usage");
                    cOptions.addArguments("--remote-allow-origins=*");
                }
                driver = new ChromeDriver(cOptions);
                devTools = ((ChromeDriver) driver).getDevTools();
                break;

            case "firefox":
                Iqsoft_001_BasePage.logger.info("Browser for test will be firefox as chosen");
                WebDriverManager.firefoxdriver().setup();
                fOptions=new FirefoxOptions();
                if (isHeadless.equals("true")){

                    fOptions.addArguments("--headless", "--window-size=1920,1080");
                    fOptions.setAcceptInsecureCerts(true);

                    fOptions.addArguments("--disable-web-security");
                    fOptions.addArguments("--ignore-certificate-errors");
                    fOptions.addArguments("--allow-running-insecure-content");
                    fOptions.addArguments("--no-sandbox");
                    fOptions.addArguments("--disable-dev-shm-usage");
                    fOptions.addArguments("--remote-allow-origins=*");
                }
                else{
                    fOptions.setAcceptInsecureCerts(true);

                    fOptions.addArguments("--disable-web-security");
                    fOptions.addArguments("--ignore-certificate-errors");
                    fOptions.addArguments("--allow-running-insecure-content");
                    fOptions.addArguments("--no-sandbox");
                    fOptions.addArguments("--disable-dev-shm-usage");
                    fOptions.addArguments("--remote-allow-origins=*");
                }
                driver = new FirefoxDriver(fOptions);
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

                }
                else{
                    eOptions.setAcceptInsecureCerts(true);
                    eOptions.addArguments("--disable-web-security");
                    eOptions.addArguments("--ignore-certificate-errors");
                    eOptions.addArguments("--allow-running-insecure-content");
                    eOptions.addArguments("--no-sandbox");
                    eOptions.addArguments("--disable-dev-shm-usage");
                    eOptions.addArguments("--remote-allow-origins=*");
                }
                driver= new EdgeDriver(eOptions);
                devTools = ((EdgeDriver) driver).getDevTools();
                break;


            default:
                Iqsoft_001_BasePage.logger.info("Browser for test will be chrome by default");
                WebDriverManager.chromedriver().setup();
                cOptions=new ChromeOptions();
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

                }
                else{  cOptions.setAcceptInsecureCerts(true);
//                    cOptions.setProxy(seleniumProxy);
                    cOptions.addArguments("--disable-web-security");
                    cOptions.addArguments("--ignore-certificate-errors");
                    cOptions.addArguments("--allow-running-insecure-content");
                    cOptions.addArguments("--no-sandbox");
                    cOptions.addArguments("--disable-dev-shm-usage");
                    cOptions.addArguments("--remote-allow-origins=*");

                }
                driver = new ChromeDriver(cOptions);
                devTools = ((ChromeDriver) driver).getDevTools();
                break;
        }
        driver.manage().window().maximize();
//        proxy.newHar("websockets");










        devTools.createSession();
        // Enable Network tracking
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


        devTools.addListener(Network.webSocketCreated(), webSocketCreated -> {
            if ( webSocketCreated.getUrl().contains("wss://virtualgameswebsitewebapi")){
            webSocketUrl = webSocketCreated.getUrl();
            }
            System.out.println("WebSocket URL: " + webSocketUrl);
        });


        driver.get(siteUrl);

        // Add a delay to allow WebSocket connections to be established
        try {
            TimeUnit.SECONDS.sleep(15); // Adjust the wait time as necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        devTools.clearListeners();

    }



}


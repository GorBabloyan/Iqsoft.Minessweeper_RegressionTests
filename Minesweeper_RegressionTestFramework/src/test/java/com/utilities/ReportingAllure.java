package com.utilities;//package utilities;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Attachment;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//import com.pageObjects.Iqsoft_001_BasePage;
//import com.testCases.Iqsoft_001_BaseTest;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//
//import static java.lang.String.format;
//
//public class ReportingAllure implements ITestListener {
//
//    private static String getTestMethodName(ITestResult iTestResult) {
//        return iTestResult.getMethod().getConstructorOrMethod().getName();
//    }
//
//    // Text attachments for Allure
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshotPNG(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    // Text attachments for Allure
//    @Attachment(value = "{0}", type = "text/plain")
//    public static String saveTextLog(String message) {
//        return message;
//    }
//
//    // HTML attachments for Allure
//    @Attachment(value = "{0}", type = "text/html")
//    public static String attachHtml(String html) {
//        return html;
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//        saveTextLog((iTestContext.getName()) + " Test execution starts");
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        saveTextLog((iTestContext.getName()) + " Test Finished");
//    }
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//        saveTextLog(getTestMethodName(iTestResult) + " TestCase execution starts");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//        saveTextLog(getTestMethodName(iTestResult) + " Test passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        Object testClass = iTestResult.getInstance();
//        WebDriver driver = Iqsoft_001_BaseTest.driver;
//        // Allure ScreenShotRobot and SaveTestLog
//
//        saveTextLog(getTestMethodName(iTestResult) + " Test failed and screenshot taken!");
//        if (driver instanceof WebDriver) {
//            Allure.addAttachment(getTestMethodName(iTestResult)+"_", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//            saveScreenshotPNG(driver);
//        }
//        // Save a log on allure.
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult iTestResult) {
//        WebDriver driver = Iqsoft_001_BaseTest.driver;
//        // Allure ScreenShotRobot and SaveTestLog
//        saveTextLog(getTestMethodName(iTestResult) + " Test Skipped and screenshot taken!");
//        if (driver instanceof WebDriver) {
//            Allure.addAttachment(getTestMethodName(iTestResult)+"_", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//            saveScreenshotPNG(driver);
//        }
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        // Allure ScreenShotRobot and SaveTestLog
//        WebDriver driver = Iqsoft_001_BaseTest.driver;
//        saveTextLog(getTestMethodName(iTestResult) + " Test failed and screenshot taken!");
//        // Allure ScreenShotRobot and SaveTestLog
//        if (driver instanceof WebDriver) {
//            Allure.addAttachment(getTestMethodName(iTestResult)+"_", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//            saveScreenshotPNG(driver);
//        }
//    }
//}


import com.pageObjects.Iqsoft_001_BasePage;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ReportingAllure extends Iqsoft_001_BaseTest implements ITestListener {
    public ReportingAllure() throws AWTException {
    }

    Iqsoft_001_BasePage basePage = new Iqsoft_001_BasePage(driver);
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public String typeByMime(String type) {
        String attachmentType = null;
        switch (type) {
//            case "image/bmp":
//            case "image/gif":
//            case "image/tiff":
//            case "image/jpeg":
//            case "image/jpg":
//            case "image/png":
            case "image/*":
//            case "text/xml":
//            case "application/xml":
            case "application/json":
            case "text/json":
//            case "text/yaml":
//            case "application/yaml":
//            case "application/x-yaml":
//            case "text/x-yaml":
            case "text/plain":
            case "text/*":
            case "text/html":
            case "text/csv":
            case "text/xlsx":
//            case "image/svg+xml":
            case "video/mp4":
            case "video/ogg":
            case "video/webm":
//            case "text/uri-list":
            default:

        }
        return attachmentType;
    }


    @Attachment(value = "{0}", type = "application/json")
    public static String saveApplicationJson(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/json")
    public static String saveTextJson(String message) {
        return message;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotAlineBorderPNG(WebDriver driver, WebElement element) {
        // Capture the screenshot of the entire page
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Read the image file
            BufferedImage fullImg = ImageIO.read(screenshot);

            // Get the location of the element on the page
            Point point = element.getLocation();

            // Get the size of the element
            int elementWidth = element.getSize().getWidth();
            int elementHeight = element.getSize().getHeight();

            // Draw a rectangle around the element
            Graphics2D g = fullImg.createGraphics();
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(3));
            g.drawRect(point.getX(), point.getY(), elementWidth, elementHeight);
            g.dispose();

            // Convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(fullImg, "png", baos);
            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        logger.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        logger.info("I am in onFinish method " + iTestContext.getName());
        }

    @Override
    public void onTestStart(ITestResult iTestResult) {
//        logger.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is failed.");

        //Get driver from Iqsoft_001_BaseTest and assign to local webdriver variable.
        Iqsoft_001_BasePage iqsoft001BasePage = new Iqsoft_001_BasePage();
        Object testClass = iTestResult.getInstance();
        WebDriver driver = iqsoft001BasePage.getDriver();

        WebElement element = iqsoft001BasePage.getElement();
        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            Iqsoft_001_BasePage.logger.error("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//            saveScreenshotPNG(driver);
            if (element!=null){
                saveScreenshotAlineBorderPNG(driver,element);
            }
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}













//public class AllureListener implements ITestListener {
//
//    private static String getTestMethodName(ITestResult iTestResult) {
//        return iTestResult.getMethod().getConstructorOrMethod().getName();
//    }
//
//    @Attachment
//    public byte[] saveFailureScreenShot(WebDriver driver) {
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Attachment(value = "{0}", type = "text/plain")
//    public static String saveTextLog(String message) {
//        return message;
//    }
//
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("I am in onStart method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        System.out.println("I am in onFinish method " + iTestContext.getName());
//    }
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
//        Object testClass = iTestResult.getInstance();
//        WebDriver driver = BaseClass.getDriver();
//        // Allure ScreenShot and SaveTestLog
//        if (driver instanceof WebDriver) {
//            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//            saveFailureScreenShot(driver);
//        }
//        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
//    }
//
//
//    @Override
//    public void onTestSkipped(ITestResult iTestResult) {
//        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
//    }
//
//}









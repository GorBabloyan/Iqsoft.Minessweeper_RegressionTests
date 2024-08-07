package com.utilities;

import com.pageObjects.Iqsoft_001_BasePage;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class ReportingAllure extends Iqsoft_001_BaseTest implements IAnnotationTransformer, ITestListener, IConfigurationListener {
    public ReportingAllure()  {
    }


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            String[] groups = annotation.getGroups();
            if (groups != null && groups.length > 0) {
                annotation.setTestName(String.join(", ", groups)); // Set test name to groups joined by comma
            } else {
                String description = annotation.getDescription();
                if (description != null && !description.isEmpty()) {
                    annotation.setTestName(description); // Set test name to description if available
                } else {
                    annotation.setTestName(testMethod.getName()); // Set test name to method name
                }
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String[] groups = result.getMethod().getGroups();
        if (groups != null && groups.length > 0) {
            result.setAttribute("allure-test-name", String.join(", ", groups)); // Set Allure attribute to groups joined by comma
        } else {
            result.setAttribute("allure-test-name", testName); // Set Allure attribute to method name if no groups
        }
    }



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
        attachHtml((iTestContext.getName()) + ": Test execution starts");
        if (driver!=null)
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Iqsoft_001_BasePage.logger.info(" Test is Finished.");
        attachHtml((iTestContext.getName()) + ": Test execution finished");
        }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test passed");
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test failed");
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is failed.");

      //Allure ScreenShotRobot and SaveTestLog
        try{
            if (driver != null) {
                saveScreenshotPNG(driver);
                Iqsoft_001_BasePage.logger.error("Screenshot captured for test case: " + getTestMethodName(iTestResult));
                saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
            }
        }
        catch(Exception e){
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is skipped.");
        attachHtml(getTestMethodName(iTestResult) + ": Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Iqsoft_001_BasePage.logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        attachHtml(getTestMethodName(iTestResult) + ": Test failed partially");
    }
}


package com.utilities;

import com.pageObjects.Iqsoft_001_BasePage;
import com.testCases.Iqsoft_001_BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static com.utilities.DriverFactory.driver;


public class ReportingAllure extends Iqsoft_001_BaseTest implements IAnnotationTransformer, ITestListener, IConfigurationListener {


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test failed");
        Iqsoft_001_BasePage.logger.info(getTestMethodName(iTestResult) + " test is failed.");

        //Allure ScreenShotRobot and SaveTestLog
        try {
            if (driver != null) {
                saveScreenshotPNG(driver);
                Iqsoft_001_BasePage.logger.error("Screenshot captured for test case: " + getTestMethodName(iTestResult));
                saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
            }
        } catch (Exception e) {
        }

    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //     Text attachments for Allure
    @Attachment(value = "{0}", type = "application/json")
    public static String saveApplicationJson(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/json")
    public static String saveTextJson(String message) {
        return message;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }


//    @Override
//    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        if (testMethod != null) {
//            String description = annotation.getDescription();
//            if (description != null && !description.isEmpty()) {
//                annotation.setTestName(description); // Set test name to description if available
//            } else {
//                annotation.setTestName(testMethod.getName()); // Set test name to method name
//            }
//        }
//    }

//    @Override
//    public void onTestStart(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//        String description = result.getMethod().getDescription();
//        if (description != null && !description.isEmpty()) {
//            result.setAttribute("allure-test-name", description); // Set Allure attribute to description if available
//        } else {
//            result.setAttribute("allure-test-name", testName); // Set Allure attribute to method name
//        }
//    }


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


    @Override
    public void onStart(ITestContext iTestContext) {
        attachHtml((iTestContext.getName()) + ": Test execution starts");
//        Iqsoft_00_BasePage.logger.info((iTestContext.getName()) + ": Test execution starts");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        attachHtml((iTestContext.getName()) + ": Test execution finished");
//        Iqsoft_00_BasePage.logger.info((iTestContext.getName()) + ": Test execution finished");

    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test passed");
//        Iqsoft_00_BasePage.logger.info(getTestMethodName(iTestResult) + ": Test Passed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test Skipped");
//        Iqsoft_00_BasePage.logger.error(getTestMethodName(iTestResult) + " Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        attachHtml(getTestMethodName(iTestResult) + ": Test failed partially");
//        Iqsoft_00_BasePage.logger.error(getTestMethodName(iTestResult) + ": Test Failed Partially");
    }


//    @Override
//    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
//        Collections.sort(methods, new Comparator<IMethodInstance>() {
//            @Override
//            public int compare(IMethodInstance o1, IMethodInstance o2) {
//                return o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
//            }
//        });
//        return methods;
//    }


}
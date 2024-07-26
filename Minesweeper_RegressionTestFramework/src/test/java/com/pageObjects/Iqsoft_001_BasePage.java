package com.pageObjects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class Iqsoft_001_BasePage {

    public static Logger logger ;
    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    Select select;
    JavascriptExecutor js;
    Robot robot;
    public int i = 1;



    public Iqsoft_001_BasePage(WebDriver driver) throws AWTException {

        Iqsoft_001_BasePage.driver = driver;
        if (driver!=null){
            actions = new Actions(driver);
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            js = (JavascriptExecutor) driver;
            robot = new Robot();
        }
    }

    public Iqsoft_001_BasePage(){
    }



    //region < Extra >

    public static void deleteFolder(File folder) {
        // Check if the provided file is a directory
        if (folder.isDirectory()) {
            // Get list of files and subdirectories within the directory
            File[] files = folder.listFiles();

            // Delete each file and subdirectory recursively
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        // Delete the directory itself
        folder.delete();
    }


    public static String dateTimeNow() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");  //2024-05-29T15:30:45.123
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //2024-06-09 12:39

        // Format the current date and time
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }




























    public static String dateTimeNowMinusOneDay() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Subtract one day from the current date and time
        LocalDateTime dateTimeMinusOneDay = currentDateTime.minusDays(1);

        // Define the desired date-time format
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");  //2024-05-29T15:30:45.123
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //2024-06-09 12:39


        // Format the date and time minus one day
        String formattedDateTime = dateTimeMinusOneDay.format(formatter);

        return formattedDateTime;
    }

    //endregion

    public boolean regexCheck(String regex, String matcher){
        boolean isRegexTrue ;

//        isRegexTrue = Pattern.compile(regex).matcher(matcher).matches();

//        Pattern p = Pattern.compile(".s");//. represents single character
//        Matcher m = p.matcher("as");
//        boolean b = m.matches();

        isRegexTrue = Pattern.matches(regex, matcher);
        return isRegexTrue;
    }



    /* this method will be used for validate webElements visibility */
    public void waitElementToBeVisible(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitElementToBeVisibleBoolean(WebElement element) {

        try {
            this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void waitFrameToBeAvailable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /* this method will be used for validate webElements click ability */
    public void waitElementTobeClickable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* this method will be used for clicking on element which is visible */
    public void clickOnElementIfVisible(WebElement element) {
        this.waitElementToBeVisible(element);
        element.click();
    }

    /* this method will be used for clicking on element which is Clickable */
    public void clickOnElementIfClickable(WebElement element) {
        this.waitElementTobeClickable(element);
        element.click();
    }

    /* this method will be used for sending keys on element which is visible */
    public void sendKeysIfElementVisible(WebElement element, String keys) {
        this.waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    public void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }


    public boolean isCheckboxSelected(WebElement checkbox){
        return checkbox.isSelected();
    }

    /* this method will be true if element is enabled */

    public boolean elementIsEnable(WebElement element) {
        return element.isEnabled();

    }

    /* this method will be true if element is Displayed */

    public boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /* this method will return true if element is selected */
    public boolean elementIsSelected(WebElement element) {
        return element.isSelected();
    }


    //region <Get>


    /* this method will be return BasePage_s driver */

    public WebDriver getDriver() {
        return this.driver;
    }

    /* this method will get attribute from element */

    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    /* this method will get attribute from element */
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /* this method will get text from element */
    public String getText(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    /* this method will get current URL */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /* this method will get current Pages source */
    public String getSource() {
        return driver.getPageSource();
    }

    /* this method will get current Pages Title */
    public String getTitle() {
        return driver.getTitle();
    }


    //endregion

    //region <Select from Dropdown>

    public Select createSelectElement(WebElement element) {
        Select s = new Select(element);
        return s;
    }

    /* this method will be used for selecting element from dropdown using visible text */
    public void selectFromDropDownByVisibleText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public String getSelectedItemText(Select element) {
        String text = element.getFirstSelectedOption().getText();
        return text;
    }
    //endregion

    //region <javaScript executor>

    /* this method will be used for scrolling down to particular element */
    public void javaScriptScrollDownToParticularElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /* this method will be used for scrolling down to particular position */
    public void javaScriptScrollDownToParticularPosition(String position) {
        js.executeScript("window.scrollBy(0," + position + ")", "");
    }

    /* this method will be used for scrolling to bottom of the page */
    public void javaScriptScrollToBottom() {
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page down */
    public void scrollPageDown() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page up */
    public void scrollPageUp() {
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void scrollToSpecificElementOnCenter(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }


    /* this method will zoom the page */
    public void zoomPageByJS(String zoomProcsent) {
        js.executeScript("document.body.style.zoom='" + zoomProcsent + "%'"); //zoom by 100%
    }

    /* this method will be used for clicking on WebElement */
    public void javaScriptClick(WebElement element) {
        waitElementTobeClickable(element);
        js.executeScript("arguments[0].click();", element);
    }

    /* this method will be used for sending text to text box */
    public void javaScriptSendKeys(String text) {
        js.executeScript("document.getElementById('q').value='" + text + "'");
    }

    /* this method will refresh browser */
    public void javaScriptRefreshBrowser() {
        js.executeScript("history.go(0)");
    }

    /* this method will draw border for element */
    public void javaScriptDrawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
    }

    /* this method will return title of the page */
    public String javaScriptGetTitle() {
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    /* this method will generate the alert window */
    public void javaScriptGenerateAlert(String massage) {
        js.executeScript("alert('" + massage + "')");
    }


    //endregion

    //region <Actions>
    public void waitAction(int waitTime) {
        actions.pause(waitTime).perform();
    }

    public void actionClickToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).build().perform();
    }

    public void actionMoveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void actionMoveToElementClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();

    }

    public void actionDoubleClick(WebElement element) {
        waitElementToBeVisible(element);
        actions.doubleClick(element).perform();
    }


    public void actionDownArrowXTime(int x) {
        for (int i = 0; i < x; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    public void actionControlA() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionControlCopy() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionControlPaste() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionTab() {
        actions.sendKeys(Keys.TAB).perform();
    }
    //endregion

    //region <Robot>
    public void robotTab() {
        robot.keyPress(KeyEvent.VK_TAB);
    }

    public void robotEnter() {
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    //endregion

    //region <Take Screenshot>
    /* this method will be take Screenshot whale page*/

    static WebElement alineElement;
    public WebElement getElement(){
        return alineElement;
    }

    public void setElement(WebElement element){
        alineElement = element;
    }

    public static void clearBrowserCache(DevTools devTools) {
        devTools.send(Network.clearBrowserCache());
        devTools.send(Network.clearBrowserCookies());
    }
    public File captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + i + tname + ".png");
        FileUtils.copyFile(source, target);
        return target;
    }

    /* this method will be take Screenshot whale page and draw Border any element we mentioned*/
    public void captureScreenDrawBorder(WebDriver driver, WebElement element, String tname) throws IOException {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    /* this method will be take Screenshot mentioned element */
    public void captureFromScreenSpecificElement(WebDriver driver, WebElement element, String tname) throws IOException {

        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Compare_Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


    //endregion

    //region <Generate emails>
    public String generateRandomMobileNumberValid() {
        String generatedNumber = RandomStringUtils.randomNumeric(8);
        return generatedNumber;
    }

    public String generateRandomEmailValid() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }

    //Abc.example.com no @ character
    public String generateRandomEmailInValid1() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + ".gmail.com";
        return randomEmail;
    }

    //A@b@c@example.com   only one @ is allowed outside quotation marks
    public String generateRandomEmailInValid2() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(5);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(5);
        randomEmail = generatedString1 + "@" + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    //a"b(c)d,e:f;g<h>i[j\k]l@example.com    ( "  none of the special characters in this local-part are allowed outside quotation marks )
    public String generateRandomEmailInValid3() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\\" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    // just"not"right@example.com (quoted strings must be dot separated or the only element making up the local-part)
    public String generateRandomEmailInValid4() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\"" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //this is"not\allowed@example.com (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
    public String generateRandomEmailInValid5() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + " " + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //i_like_underscore@but_its_not_allowed_in_this_part.example.com (Underscore is not allowed in domain part)
    public String generateRandomEmailInValid6() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "_" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //endregion

    //region <Navigation>
    public void navigateForward() {
        driver.navigate().forward();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateRefresh() {
        driver.navigate().refresh();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    //endregion

    //region <Window Handling>
    public void handleWindowsWithArrayList(int index) {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(index));
//        //switch to new tab
//        driver.switchTo().window(newTb.get(1));
//        //switch to parent window
//        driver.switchTo().window(newTb.get(0));
    }

    public void switchToTab(String name) {
        driver.switchTo().window(name);
    }

    public void switchToNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchToDefaultTab() {
        driver.switchTo().defaultContent();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    //endregion

    //region <Local storage>
    public org.openqa.selenium.html5.LocalStorage getLocalStorage() {
        WebStorage webStorage = (WebStorage) driver;
        return webStorage.getLocalStorage();
    }

    public String getItem(String key) {
        return getLocalStorage().getItem(key);
    }

    public void setItem(String key, String value) {
        getLocalStorage().setItem(key, value);
    }

    //endregion

    /* this method will be return integer number num symbols */
    public static String randomNum(int num) {
        String generatedInt = RandomStringUtils.randomNumeric(num);
        return (generatedInt);
    }

    /* this method will be return True if Response cod is 0-300 */
    public static boolean checkConnectionUrlResponseCod(String url) {
        boolean responseCodOK;

        if (url == null || url.isEmpty()) {
            System.out.println("  Empty link");
            responseCodOK = false;
        } else {
            try {
                URL link = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) link.openConnection();
                connection.connect();
                int cod = connection.getResponseCode();

                if (cod >= 100 && cod < 200) {
//                    System.out.println(url + " Info Message  " + cod);
                    responseCodOK = true;
                } else if (cod >= 200 && cod < 300) {
//                    System.out.println(url + " Response cod is OK  " + cod);
                    responseCodOK = true;
                } else if (cod >= 300 && cod < 400) {
//                    System.out.println(url + " Server Redirection  " + cod);
                    responseCodOK = false;
                } else if (cod >= 400 && cod < 500) {
//                    System.out.println(url + " Client error  " + cod);
                    responseCodOK = false;
                } else if (cod >= 500) {
//                    System.out.println(url + " Server error  " + cod);
                    responseCodOK = false;
                } else {
//                    System.out.println(" Something went wrong  ");
                    responseCodOK = false;
                }

            } catch (Exception e) {
                responseCodOK = false;
//                System.out.println("We have Exception  --> " + e);
            }
        }

        return responseCodOK;
    }

    public ArrayList<String> getBrowserErrors() {
        driver.get("https://pokies2go.io/casino/all-games");
        ArrayList<String> browserErrors = new ArrayList<>();
        LogEntries logEntries = driver.manage().logs().get("browser");
        int i = 1;
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            String errorLogType = entry.getLevel().toString();
            String errorLog = entry.getMessage().toString();
            if (errorLog.contains("400") || errorLog.contains("401") || errorLog.contains("402") || errorLog.contains("403") || errorLog.contains("404") || errorLog.contains("405") || errorLog.contains("Error") || errorLog.contains("ERROR") || errorLog.contains("error") || errorLog.contains("Failed") || errorLog.contains("Unchecked") || errorLog.contains("Uncaught")) {
                browserErrors.add("Error LogType: " + errorLogType + " Error Log message: " + errorLog);
                i++;
            }
        }

        return browserErrors;
    }
}
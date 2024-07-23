package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Iqsoft_Page_01_Header extends Iqsoft_001_BasePage{

    private final Iqsoft_001_BasePage iqsoft001BasePage;

    public Iqsoft_Page_01_Header(WebDriver driver) throws AWTException {
        super(driver);
        iqsoft001BasePage = new Iqsoft_001_BasePage(driver);
    }

    @FindBy(xpath = "//*[@class='mobile-size']")
    @CacheLookup
    WebElement header;

    public void clickOnHeader() {
        try {
            iqsoft001BasePage.elementIsDisplayed(header);
            iqsoft001BasePage.clickOnElementIfClickable(header);

        } catch (Exception e) {
            logger.error("clickOnHeader() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='logo']//img")
    @CacheLookup
    WebElement logoImg;

    public boolean checkLogoImgLink() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(logoImg);
            String src = iqsoft001BasePage.getAttribute(logoImg,"src");
            URL img = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) img.openConnection();
            connection.connect();
            int cod = connection.getResponseCode();
            System.out.println(">>>>>>>>>" +cod);
            if (cod<400){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            logger.error("checkLogoImgLink() method has an Exception: " + e);
            return false;
        }
    }

    @FindBy(xpath = "//div[@class='logo']//span")
    @CacheLookup
    WebElement gameTitle;

    public String getTextGameTitle() {
        String textGameTitle = null;
        try {
            iqsoft001BasePage.waitElementToBeVisible(gameTitle);
            textGameTitle = iqsoft001BasePage.getText(gameTitle);

        } catch (Exception e) {
            logger.error("getTextGameTitle() method has an Exception: " + e);
        }
        return textGameTitle;
    }


    @FindBy(xpath = "//div[@class='user']//div[@class='text-info']")
    @CacheLookup
    WebElement textUserID;

    public String getTextUserID() {
        String textUserId = null;
        try {
            iqsoft001BasePage.waitElementToBeVisible(textUserID);
            textUserId = iqsoft001BasePage.getText(textUserID);

        } catch (Exception e) {
            logger.error("getTextUserID() method has an Exception: " + e);
        }
        return textUserId;
    }


    @FindBy(xpath = "//div[@class='user']//div[@class='user-id']")
    @CacheLookup
    WebElement userId;

    public int getUserID() {
        int id = 0;
        try {
            iqsoft001BasePage.waitElementToBeVisible(userId);
            id = Integer.parseInt(iqsoft001BasePage.getText(userId));

        } catch (Exception e) {
            logger.error("getUserID() method has an Exception: " + e);
        }
        return id;
    }


    @FindBy(xpath = "//div[@class='balance']//div[@class='text-info']")
    @CacheLookup
    WebElement textBalance;

    public String getTextBalance() {
        String text = null;
        try {
            iqsoft001BasePage.waitElementToBeVisible(textBalance);
            text = iqsoft001BasePage.getText(textBalance);

        } catch (Exception e) {
            logger.error("getTextBalance() method has an Exception: " + e);
        }
        return text;
    }

    @FindBy(xpath = "//div[@class='balance']//div[@class='balance-sum']")
    @CacheLookup
    WebElement balance;

    public String getCurrency() {
        String text = null;
        String currency = null;
        try {
            iqsoft001BasePage.waitElementToBeVisible(balance);
            text = iqsoft001BasePage.getText(balance);
            String[] parts = text.split(" ");
            currency = parts[0];
            String balanceStr = parts[1].replace(",", "");
            double balance = Double.parseDouble(balanceStr);

        } catch (Exception e) {
            logger.error("getCurrency() method has an Exception: " + e);
        }
        return currency;
    }

    public double getBalance() {
        String text = null;
        double clientBalance = -1;
        try {
            iqsoft001BasePage.waitElementToBeVisible(balance);
            text = iqsoft001BasePage.getText(balance);
            String[] parts = text.split(" ");

            String balanceStr = parts[1].replace(",", "");
            clientBalance = Double.parseDouble(balanceStr);

        } catch (Exception e) {
            logger.error("getBalance() method has an Exception: " + e);
        }
        return clientBalance;
    }


    @FindBy(xpath = "//button[@class='btn_play']")
    @CacheLookup
    WebElement iconInfo;

    public boolean isVisibleInfoIcon() {
        boolean isVisible = false;
        try {
            isVisible = iqsoft001BasePage.elementIsDisplayed(iconInfo);

        } catch (Exception e) {
            logger.error("isVisibleInfoIcon() method has an Exception: " + e);
        }
        return isVisible;
    }

    public void clickOnInfoIcon() {
        try {
            iqsoft001BasePage.elementIsDisplayed(iconInfo);
            iqsoft001BasePage.clickOnElementIfClickable(iconInfo);

        } catch (Exception e) {
            logger.error("clickOnInfoIcon() method has an Exception: " + e);
        }
    }


    @FindBy(xpath = "//button[@class='btn_play']")
    @CacheLookup
    WebElement iconMute;

    public boolean isVisibleMuteIcon() {
        boolean isVisible = false;
        try {
            isVisible = iqsoft001BasePage.elementIsDisplayed(iconMute);

        } catch (Exception e) {
            logger.error("isVisibleMuteIcon() method has an Exception: " + e);
        }
        return isVisible;
    }

    public void clickOnMuteIcon() {
        try {
            iqsoft001BasePage.elementIsDisplayed(iconInfo);
            iqsoft001BasePage.clickOnElementIfClickable(iconMute);

        } catch (Exception e) {
            logger.error("clickOnMuteIcon() method has an Exception: " + e);
        }
    }



    @FindBy(xpath = "//button[@class='btn_play']")
    @CacheLookup
    WebElement buttonPlay;

    public void clickOnButtonPlay() {
        try {
            iqsoft001BasePage.waitElementToBeVisible(buttonPlay);
            iqsoft001BasePage.clickOnElementIfClickable(buttonPlay);

        } catch (Exception e) {
            logger.error("clickOnButtonPlay() method has an Exception: " + e);
        }
    }






















    // Getters


    public WebElement getWebElementHeader() {
        return header;
    }

    public WebElement getWebElementLogoImg() {
        return logoImg;
    }

    public WebElement getWebElementGameTitle() {
        return gameTitle;
    }

    public WebElement getWebElementTextUserId() {
        return textUserID;
    }

    public WebElement getWebElementUserId() {
        return userId;
    }


    public WebElement getWebElementTextBalance() {
        return textBalance;
    }

    public WebElement getWebElementBalance() {
        return balance;
    }




    public WebElement getIconInfo() {
        return iconInfo;
    }

    public WebElement getIconMute() {
        return iconMute;
    }

    public WebElement getButtonPlay() {
        return buttonPlay;
    }


}

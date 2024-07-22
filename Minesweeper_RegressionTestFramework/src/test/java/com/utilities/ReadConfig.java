package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig()
    {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }


    public String getBaseURL()
    {
        return pro.getProperty("baseURL");
    }
    public String getWebSitWebApi()
    {
        return pro.getProperty("websitewebapi");
    }

    public String getBrowser()
    {
        return pro.getProperty("browser");
    }
    public String isHeadless()   {
        return  pro.getProperty("headless");

    }
    public int getDimensionWidth()
    {
        return  Integer.parseInt(pro.getProperty("DimensionWidth"));

    }
    public int getDimensionHeight()
    {
        return Integer.parseInt(pro.getProperty("DimensionHeight"));
    }
    public int getProductId()
    {
        return Integer.parseInt(pro.getProperty("ProductId"));
    }
    public String getData()
    {
        return pro.getProperty("Data");

    }

    public String getLoginToken()
    {
        return pro.getProperty("LoginToken");
    }




}

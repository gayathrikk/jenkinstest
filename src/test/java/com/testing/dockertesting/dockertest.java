package com.testing.dockertesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class dockertest {

    private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url, dc);
    }

    @Test
    public void testWebsiteTitle() {
        driver.get("http://public.humanbrain.in");
        String title = driver.getTitle();
        System.out.println("Title of the page=" +title);
    }

    @AfterTest
    public void close() {
       
            driver.quit();
        }
    }


package com.n11.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Initialize {
    public static WebDriver driver;
    protected static Map<String, String> TDMap = new HashMap<String, String>();
    protected static WebDriverWait wait;

    protected static CommonMethodes methodes = new CommonMethodes();

    File T = new File("src/test/resources/testdata");
    File Tstdt = new File(T, "TestData.properties");

    public String getTestDataPF(String KeyName) {
        Properties prop = null;
        InputStream IP = null;
        try {
            IP = new FileInputStream(Tstdt.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String Val = prop.getProperty(KeyName);
        return Val;

    }

    @BeforeClass
    public void setUpClass() throws Exception {
        driver = initializeDriver();
    }


    @AfterClass
    public void tearDownClass() throws Exception {
        System.out.flush();
        driver.quit();
       // driver.close();
        TDMap = new HashMap();
    }

    public WebDriver initializeDriver() throws IOException {
        System.out.println("*******************");
        System.out.println("Launching Chrome Browser");
        File f = new File("src/test/resources/drivers/windows");
        File ChromeDriver = new File(f, "chromedriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximised");
        System.setProperty("webdriver.chrome.driver", ChromeDriver.getAbsolutePath());
        LoggingPreferences logP = new LoggingPreferences();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logP);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getTestDataPF("ImplicitWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(getTestDataPF("ExplicitWait")));

        return driver;
    }

}



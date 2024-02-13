package Utilities;

import com.google.gson.stream.JsonReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Utils {

    private ExcelReader excelReader = new ExcelReader();
    private ConfigReader configReader = new ConfigReader();
    private Properties prop = configReader.init_prop();
    private WebDriver driver;
    public static final long explicitWaitTime = 15;//Constant

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void launchApp() {
        String appURL = prop.getProperty("AppURL");
        driver.get(appURL);

    }

    public List<Map<String, String>> getExcelTestData(String testcaseID, String sheetName) {
        String filePath = prop.getProperty("ExcelPath");
        return excelReader.readExcelData(filePath, sheetName, testcaseID);
    }

    public void clickElement(By locatorElement) {
        WebElement webElement = getClickableElement(locatorElement);
        webElement.click();
    }

    public void typeTextIntoElement(By locatorElement, String textToBeTyped) {
        WebElement webElement = getClickableElement(locatorElement);
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    public void selectDropdownValue(By locatorElement, String dropDownValue) {
        WebElement webElement = getClickableElement(locatorElement);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownValue);
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = waitForAlert();
        alert.dismiss();

    }

    private WebElement getClickableElement(By locatorElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(getWaitDuration()))
                .until(ExpectedConditions.elementToBeClickable(locatorElement));
    }

    private Alert waitForAlert() {
        return new WebDriverWait(driver, Duration.ofSeconds(getWaitDuration()))
                .until(ExpectedConditions.alertIsPresent());
    }

    private long getWaitDuration() {
        return explicitWaitTime;
    }

    private WebElement waitForVisibilityOfElement(By locatorElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(getWaitDuration()))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locatorElement)));

    }


    public void jsClick(By locatorElement) {
        WebElement webElement = waitForVisibilityOfElement(locatorElement);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    public void jsTypeText(By locatorElement, String textToBeTyped) {
        WebElement webElement = waitForVisibilityOfElement(locatorElement);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
    }

    //write a method to get the text of an element
    public String getElementText(By locatorElement) {
        WebElement webElement = waitForVisibilityOfElement(locatorElement);
        return webElement.getText();
    }

    //write a method to get all the links in a page
    public List<String> getAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> linkTexts = new ArrayList<>();
        for (WebElement link : links) {
            linkTexts.add(link.getText());
        }
        return linkTexts;
    }

    //write a method to handle the dropdown using click and select
    public void selectDropdownValueUsingClickAndSelect(By locatorElement, String dropDownValue) {
        WebElement webElement = waitForVisibilityOfElement(locatorElement);
        webElement.click();
        List<WebElement> options = webElement.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(dropDownValue)) {
                option.click();
                break;
            }
        }
    }








}



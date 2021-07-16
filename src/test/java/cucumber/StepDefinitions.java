package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.logging.Logger;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    WebDriver driver = new ChromeDriver();
    int deleteButtonCount;
    private static Logger log = Logger.getLogger("InfoLogging");
    private final String correctMessageInAlert = "You selected a context menu";

    @Given ("The Internet herokuApp page is opened")
    public void TheInternetHerokuAppPageIsOpened() {
        driver.get("http://the-internet.herokuapp.com/");
        log.info("Logged in http://the-internet.herokuapp.com/");
    }

    @When("I click on {string} link")
    public void clickOnLink (String link) {
        WebElement webElementLink = driver.findElement(By.linkText(link));
        webElementLink.click();
    }
    @When("I click on Add Element button")
    public void iClickOnButton() {
        WebElement addButton = driver.findElement(By.cssSelector(".example>button"));
        addButton.click();
    }

    @When("I click on Delete button")
    public void iClickOnDeleteButton() {
        WebElement deleteButton = driver.findElement(By.className("added-manually"));
        deleteButton.click();
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String expectedText) {
        String actualText = driver.findElement(By.cssSelector("h3")).getText();
        assertEquals(expectedText, actualText);
        log.info("Expected: " + expectedText );
        log.info("actual: " + actualText );
    }

    @Then("I should show {string}")
    public void iShouldShow(String expectedText) {
        String actualText = driver.findElement(By.cssSelector("p")).getText();
        assertEquals(expectedText, actualText);
        log.info("Expected: " + expectedText );
        log.info("actual: " + actualText );
    }

    @Then("Delete object list contains {int} button in list")
    public void deleteObjectListContainsButtonInList(int expectedCount) {
        assertEquals(expectedCount, deleteButtonCount);
        log.info("Expected: " + expectedCount );
        log.info("actual: " + deleteButtonCount );
    }

    @Then("Delete object is added")
    public void deleteObjectIsAdded() {
        try{
            List<WebElement> addButton = driver.findElements(By.cssSelector(".example>div>button"));
            deleteButtonCount = addButton.size();
        }catch (Exception e){
            deleteButtonCount = 0;
        }
    }

    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }


    @When("I click on Add Element button {int} times")
    public void iClickOnAddElementButtonTimes(int value) {
        do {
            iClickOnButton();
            deleteButtonCount++;
        }
        while (deleteButtonCount < value);
        deleteObjectIsAdded();
    }




    @Then("Button is removed")
    public void buttonIsRemoved() {
        deleteObjectIsAdded();
    }

    @When("I log in as user {string} with password {string}")
    public void iLogInAsUserWithPassword(String login, String password) {
        driver.get("http://"+ login + ":" + password+"@the-internet.herokuapp.com/basic_auth");
    }

    @Then("User is logged successfully")
    public void userIsLoggedSuccessfully() {
        String actualText01 = driver.findElement(By.cssSelector("h3")).getText();
        String actualText02 = driver.findElement(By.cssSelector("p")).getText();
        log.info(actualText01);
        log.info(actualText02);
        assertEquals("Basic Auth",actualText01);
        assertEquals("Congratulations! You must have the proper credentials.",actualText02);
    }


    @Then("I return list with broken images")
    public void iReturnListWithBrokenImages() {
        for (WebElement image : driver.findElements(By.cssSelector("img"))) {
            if (image.getAttribute("naturalHeight").equals("0")) {
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            }
        }
    }

    @Then("I get actual checkbox statuses")
    public void iGetActualCheckboxStatuses() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
        for (WebElement checkbox : checkboxes) {
            System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
        }
    }

    @When("I right click on context menu")
    public void iRightClickOnContextMenu() {
        Actions actions = new Actions(driver);
        WebElement sector = driver.findElement(By.id("hot-spot"));
        actions.contextClick(sector).perform();
    }

    @Then("i get javascript alert")
    public boolean iGetJavascriptAlert() throws AWTException, InterruptedException {
        Alert alert = driver.switchTo().alert();
        log.info("Alert text: " + alert.getText());
        return alert.getText().equals(correctMessageInAlert);
    }

}
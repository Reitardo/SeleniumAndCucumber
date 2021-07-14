package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StepDefinitions {
    WebDriver driver = new ChromeDriver();
    int deleteButtonCount;

    @Given ("The Internet herokuApp page is opened")
    public void TheInternetHerokuAppPageIsOpened() {
        driver.get("http://the-internet.herokuapp.com/");
    }

    @When("I click on {string} object")
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
    }

    @Then("I should show {string}")
    public void iShouldShow(String expectedText) {
        String actualText = driver.findElement(By.cssSelector("p")).getText();
        assertEquals(expectedText, actualText);
    }

    @Then("Delete object list contains {int} button in list")
    public void deleteObjectListContainsButtonInList(int expectedCount) {
        assertEquals(expectedCount, deleteButtonCount);
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
}
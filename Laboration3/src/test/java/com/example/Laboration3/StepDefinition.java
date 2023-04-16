package com.example.Laboration3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    static WebDriver driver;

    @Given("Webpage is avaliable")
    public void webpage_is_avaliable() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @When("user visits SVT Play")
    public void user_visits_svt_play() {
        driver.get("https://svtplay.se");
        driver.manage().window().maximize();
        WebElement cookieSettings = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/button[3]"));
        cookieSettings.click();
    }

    @Then("title would be {string}")
    public void title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Title do not match");
    }

    @Then("logo is visable")
    public void logo_is_visable() {
        Boolean Display = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/a")).isDisplayed();

        Assertions.assertTrue(Display);
    }

    @Then("Menu item Start is avaliable")
    public void menu_item_start_is_avaliable() {
        String menuStart = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[1]")).getText();
        assertEquals("START", menuStart, "Menu item is incorrect");
    }

    @Then("Menu item Program is avaliable")
    public void menu_item_program_is_avaliable() {
        String menuProgram = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]")).getText();
        assertEquals("PROGRAM", menuProgram, "Menu item is incorrect");
    }

    @Then("Menu item Kanaler is avaliable")
    public void menu_item_kanaler_is_avaliable() {
        String menuKanaler = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[3]")).getText();

        assertEquals("KANALER", menuKanaler, "Menu item is incorrect");
    }

    @Given("menu program is avaliable")
    public void menu_program_is_avaliable() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://svtplay.se");
        driver.manage().window().maximize();
        WebElement cookieSettings = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/button[3]"));
        cookieSettings.click();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]")));

    }

    @When("user clicks menu item program")
    public void user_clicks_menu_item_program() {
        WebElement programsLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]/a"));
        programsLink.click();
    }

    @Then("number of categories should be {int}")
    public void number_of_categories_should_be(int categorySize) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-3b830fc0-0")));
        List<WebElement> menuItems = driver.findElements(By.className("sc-a9073dc0-0"));
        assertEquals(categorySize, menuItems.size(), "antalet länkar är inte korrekt");
    }

    @Then("Sign language title should be {string}")
    public void sign_language_title_should_be(String ExpectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]")));

        WebElement programsLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]/a"));
        programsLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"play_main-content\"]/div/section[1]/ul/li[2]/a")));

        String signLanguageText = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/div/section[1]/ul/li[2]/a")).getText();

        assertEquals(ExpectedTitle, signLanguageText, "Text wrong or missing");
    }

    @When("user press sign language page")
    public void user_press_sign_language_page() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]")));

        WebElement programsLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]/a"));
        programsLink.click();
    }

    @Then("Access sign language programs page and check title should be {string}")
    public void access_sign_language_programs_page_and_check_title_should_be(String actualTitle) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]")));

        WebElement programsLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]/a"));
        programsLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"play_main-content\"]/div/section[1]/ul/li[2]/a")));

        WebElement signLanguageLink = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/div/section[1]/ul/li[2]/a"));
        signLanguageLink.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"play_main-content\"]/section")));
        String websiteTitle = driver.getTitle();

        assertEquals(websiteTitle, actualTitle, "Title do not match");

    }

    @Then("user click news category and pagetitle should be {string}")
    public void user_click_news_category_and_pagetitle_should_be(String ExpectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]")));

        WebElement searchBar = driver.findElement(By.cssSelector("input[name='q']"));
        searchBar.click();

        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Nyheter");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[5]/form/button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a")));

        driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-6b1c5b48-1")));
        String ActualTitle = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/h1/span[2]")).getText();

        assertEquals(ExpectedTitle, ActualTitle, "Text wrong or missing");

    }

}


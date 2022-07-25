package com.example.Steps;

import com.example.Base.BaseClass;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_ImportPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class importStudy extends BaseClass {
    static WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }

    @When("^I enter Username and password")
    public void i_enterusername_and_password() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //webdriver.quit();
//        objTrialsPage=new B_TrialsPage(driver);
//        objTrialsPage.clickTrialsMenuOption();
    }


    @Given("I click on import")
    public void iClickOnImport() {
        B_ImportPage importPage=new B_ImportPage(driver);
        importPage.clickImport();
    }

    @When("I type into ClinicalTrials Identifier")
    public void iTypeIntoClinicalTrialsIdentifier() {
        B_ImportPage importPage=new B_ImportPage(driver);
        importPage.typeIntoClinicalTrialsId();
    }

    @Then("I click on Search Studies")
    public void iClickOnSearchStudies() {
        B_ImportPage importPage=new B_ImportPage(driver);
    }

    @Then("I click on Import trial")
    public void iClickOnImportTrial() {
        B_ImportPage importPage=new B_ImportPage(driver);
        importPage.clickImportTrial();
    }

    @Then("I assert results")
    public void iAssertResults() {
        B_ImportPage importPage=new B_ImportPage(driver);
        importPage.assertStep();
    }

    @Then("I logout")
    public void iLogout() {
        B_ImportPage importPage=new B_ImportPage(driver);
        importPage.logout();
    }
}

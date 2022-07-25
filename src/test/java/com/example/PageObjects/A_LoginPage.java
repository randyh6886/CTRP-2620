package com.example.PageObjects;

import com.example.Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class A_LoginPage extends BaseClass {
    public static WebDriver webDriver;

    public A_LoginPage(WebDriver driver) {
        this.webDriver=driver;
        //PageFactory.initElements(driver,this);
    }

    public void setUserName(){
        WebElement uName=webDriver.findElement(By.id("okta-signin-username"));//cssSelector("#okta-signin-username"));
        uName.sendKeys("NCIPA_Super_Abstractor@mail.nih.gov");
    }

    public void setPassword(){
        WebElement pWord=webDriver.findElement(By.id("okta-signin-password"));
        pWord.sendKeys("BoozAllen#2022");
    }

    public void clickSigninSubmit(){
        WebElement signinSubmit= webDriver.findElement(By.cssSelector("#okta-signin-submit"));
        signinSubmit.click();
    }

    public void clickProtocolAbstraction() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector(".fas")).click();
        //"div.v-select__slot>div.v-input__append-inner>" +
        //"div.v-input__icon.v-input__icon--append>i.v-icon.notranslate.fas.fa-caret-down.theme--light")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("div.v-list-item__content")).click();
                //id("list-item-56-0")).click();
        //cssSelector("div.v-list-item__content")).click();
    }

    public void clickAccept() throws InterruptedException {
        webDriver.findElement(By.cssSelector(".confirm")).click();

        //WebElement acceptBtn=webDriver.findElement(By.cssSelector(".confirm"));
        //acceptBtn.click();
        Thread.sleep(45000);

    }


//    @Then("^I click Accept$")
//    public void iClickAccept() throws Throwable{
//        webDriver.findElement(By.cssSelector("#acceptDisclaimer > span.btn_img")).click();
//        Thread.sleep(45000);
//    }
    // trying to put the above in its own page to try to avoid the NoSuchElementException that was generated with it
}





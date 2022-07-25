package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class B_ImportPage extends BaseClass {
    // old implementation is below and gave null pointer exception - here is new attempt

    public static WebDriver weBdriver;

    public B_ImportPage(WebDriver ldriver) {
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver,this);
    }
    public void clickImport(){
        weBdriver.findElement(By.id("importCtGovMenuOption")).click();
    }
    public void typeIntoClinicalTrialsId(){
        weBdriver.findElement(By.id("nctID")).click();
        weBdriver.findElement(By.id("nctID")).sendKeys("NCT04916730");
    }
    public void clickSearchStudies(){
        weBdriver.findElement(By.cssSelector(".search")).click();
    }
    public void clickImportTrial(){
        weBdriver.findElement(By.cssSelector(".actionsrow .search")).click();
    }
    public void assertStep(){
        assertThat(weBdriver.findElement(By.cssSelector(".confirm_msg")).getText(), is("Message. An update to trial(s) with identifiers NCT04916730 and NCI-2021-00018 has been made successfully."));

    }
    public void logout(){
        weBdriver.findElement(By.linkText("Logout")).click();
    }
}

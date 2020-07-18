package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 extends BaseDriver {


    /*
        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on companies button
        Click on create companies button
        Enter the company domain
        Enter the name
        Click on Create company button
        Verify company domain as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */
    @Parameters({"username","password"})
    @Test
    public void login(String username,String password) throws InterruptedException {
        driver.get("https://app.hubspot.com/login");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.titleIs("HubSpot Login"));
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#loginBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contacts")));
        driver.findElement(By.linkText("Contacts")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-secondary-companies")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Create company']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#UIFormControl-31")));
        driver.findElement(By.cssSelector("#UIFormControl-31")).sendKeys("https://techno.study/");
        WebElement element = driver.findElement(By.cssSelector("#UIFormControl-33"));
        element.clear();
        element.sendKeys("TECHNO STUDY");
        driver.findElement(By.cssSelector("button[data-loading-state='idle']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".m-bottom-1 span.iFJVxe")));
        Assert.assertEquals("TECHNO STUDY",driver.findElement(By.cssSelector(".m-bottom-1 span.iFJVxe")).getText());
        driver.findElement(By.cssSelector("#uiabstractdropdown-button-9")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i18n-string[text()='Delete']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[data-selenium-test*=delete]>i18n-string")).click();

    }



}

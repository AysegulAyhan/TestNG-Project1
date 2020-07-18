package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver{

    /*

        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on contacts button
        Click on create contact button
        Enter email
        Enter First name
        Enter Last name
        Click on Create Contact button
        Verify email and first name as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */
    @Parameters({"username","password"})
   @Test
    public void login(String username, String password) throws InterruptedException {
       driver.get(" https://app.hubspot.com/login");
       driver.manage().window().maximize();
       wait.until(ExpectedConditions.titleIs("HubSpot Login"));
       driver.findElement(By.cssSelector("#username")).sendKeys(username);
       driver.findElement(By.cssSelector("#password")).sendKeys(password);
       driver.findElement(By.cssSelector("#loginBtn")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contacts")));
       driver.findElement(By.linkText("Contacts")).click();
       driver.findElement(By.cssSelector("div[role='menu'] a[id*='contacts']")).click();
       Thread.sleep(1000);
       driver.findElement(By.xpath("//*[text()='Create contact']")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#UIFormControl-31")));
       driver.findElement(By.cssSelector("#UIFormControl-31")).sendKeys("emilhummat@gmail.com");
       driver.findElement(By.cssSelector("#UIFormControl-33")).sendKeys("Emil");
       driver.findElement(By.cssSelector("#UIFormControl-37")).sendKeys("Hummat");
       driver.findElement(By.cssSelector("button[data-loading-state='idle']")).click();
       Thread.sleep(5000);
       Assert.assertEquals("Emil Hummat",driver.findElement(By.cssSelector(".m-bottom-1 span.iFJVxe")).getText());
       driver.findElement(By.cssSelector("#uiabstractdropdown-button-9")).click();
       Thread.sleep(1000);
       //driver.findElement(By.xpath("//i18n-string[text()='Delete']")).click();
       driver.findElement(By.cssSelector("button[data-selenium-test*='delete']")).click();
       Thread.sleep(3000);
       driver.findElement(By.cssSelector("button[data-selenium-test*=delete]>i18n-string")).click();
   }

}

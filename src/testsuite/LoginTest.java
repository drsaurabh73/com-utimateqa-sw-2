package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter the username
    WebElement userName = driver.findElement(By.id("username"));
    userName.sendKeys("tomsmith");
    // Enter the Password
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("SuperSecretPassword!");
    //Click on Login
    WebElement loginLink = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    loginLink.click();

   // Verify the text Secure Area
   String expectedResult = "Secure Area";
   WebElement actualMessage = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));
  String actualMessageDisp = actualMessage.getText();

    Assert.assertEquals("Unable to Reach Secure Area",expectedResult,actualMessageDisp);
}
@Test
    public void verifyTheUserNameErrorMessage() {
     WebElement userName = driver.findElement(By.id("username"));
     userName.sendKeys("tomsmith1");
     // Enter the Password
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("SuperSecretPassword!");
    // click on login
    WebElement loginLink = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    loginLink.click();
// expected result
    String expectedResult = "Your username is invalid!\n" +
            "×";
    // acutal result
    WebElement actualResult = driver.findElement(By.xpath("//div[@id='flash']"));
    String actualMessageDisp = actualResult.getText();
// match the actual and expected are same or not
    Assert.assertEquals("Invalid user name",expectedResult,actualMessageDisp);
}
@Test
    public void verifyThePasswordErrorMessage() {
        // enter email address in the email field
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        // enter invalid password in the password field
    WebElement password =driver.findElement(By.name("password"));
    password.sendKeys("“SuperSecretPassword");
    //click on the login
    WebElement loginLink = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    loginLink.click();
    //actual result
    String expectedResult = "Your password is invalid!\n" +
            "×";
    WebElement actualResult = driver.findElement(By.xpath("//div[@id='flash']"));
    String actualResultDisp = actualResult.getText();
    Assert.assertEquals("incorrect Password",expectedResult,actualResultDisp);

}
}

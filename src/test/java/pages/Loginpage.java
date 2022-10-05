package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
    WebDriver driver;
    public Loginpage(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement usernamepom()
    {

        return driver.findElement(By.id("username")) ;
    }
    public WebElement passwordpom()
    {

        return driver.findElement(By.name("password")) ;
    }

    public WebElement flashpom()
    {

        return driver.findElement(By.id("flash")) ;
    }
    public void  loginsteps(String username , String password)
    {
        usernamepom().clear();
        usernamepom().sendKeys(username);
        passwordpom().sendKeys(password);

    }
}

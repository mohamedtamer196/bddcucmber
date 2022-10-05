package stepdefination;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Loginpage;

public class loginstepdefanation {
    WebDriver driver = null;
    Loginpage login;


    @And("user navigates to login page")
    public void user_navigates()
    {

        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }
    @When("USER ENTER \"(.*)\" and \"(.*)\"$")
    public void valid_ENTER(String username,String password)
    {
        login.loginsteps(username,password);

    }
    @And("USER CLICK ON LOGIN BUTTON")
    public void LOGIN_BUTTON()  {
        login.passwordpom().sendKeys(Keys.ENTER);


    }
    @Then("USER COULD LOGIN SUCCESSFULLY")
    public void LOGIN_SUCCESSFULLY()
    {
        String expectedresult = "You logged into a secure area!";

        String actualresult = login.flashpom().getText();
        //hard assertion

        //first assertion
        Assert.assertTrue(actualresult.contains(expectedresult));
        //second assertion
        Assert.assertTrue(actualresult.contains(expectedresult));
        //third assertion

    }
    @Then("USER COULD not LOGIN SUCCESSFULLY")
    public void rong_SUCCESSFULLY()
    {
        String expectedresult = "Your username is invalid!";
        String actualresult = driver.findElement(By.id("flash")).getText();
        System.out.println("actualresult" + actualresult);
        Assert.assertTrue("error message : text is rong",actualresult.contains(expectedresult));


    }
    @And("AND GO TO HOME PAGE")
    public void HOME_PAGE()
    {
        Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());

    }
    @Before
    public void OpenBrowser() throws InterruptedException {
      /*  String chormepath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe" ;
        System.out.println(chormepath);
        System.setProperty("webdriver.chrome.driver", chormepath);*/

        WebDriverManager.chromedriver().setup();     //2-  new object
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(3000);
        login = new Loginpage(driver);
        
    }
    @After
    public void closed_PAGE()
    {
driver.quit();
    }
}

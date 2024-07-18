package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class nopcommerceSteps {
    WebDriver driver;



    @Given("the user is on the nopCommerce login page")
    public void the_user_is_on_the_nop_commerce_login_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String email, String password) {
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[contains(.,'Log in')]")).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        boolean status = driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Welcome to our store')]")).isDisplayed());

    }

    @Then("the user is done")
    public void the_user_is_done() {
        driver.quit();
    }

    @Then("the user should be able to click on the logout")
    public void theUserShouldBeAbleToClickOnTheLogout() {
        driver.findElement(By.xpath("//a[contains(.,'Log out')]")).click();
        boolean loginDisplayed = driver.findElement(By.xpath("//a[contains(.,'Log in')]")).isDisplayed();
        Assert.assertTrue(loginDisplayed);
    }

    //jewlery rental feature
    @Given("the user has selected which jewelery to rent")
    public void the_user_has_selected_which_jewelery_to_rent() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(.,'Jewelry')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Gemstone')]")).click();

    }
    @When("the user decides to rent the jewelery for {int} days")
    public void the_user_decides_to_rent_the_jewelery_for_days_ahead(Integer numOfDays) {
        driver.findElement(By.xpath("//input[@id='rental_start_date_40']")).click();// click start date text box
        driver.findElement(By.xpath("//a[@title='Next']")).click(); //click next tab of table
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/*[2]/*[2]/*[1]")).click();//click on 1st column of 2nd row

        driver.findElement(By.xpath("//input[@id='rental_end_date_40']")).click();// click end date text box
        driver.findElement(By.xpath("//a[@title='Next']")).click(); //click next tab of table
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/*[2]/*[2]/*[" + (1+numOfDays)+ "]")).click();//click on 3rd column of 2nd row

        driver.findElement(By.xpath("//button[@id='add-to-cart-button-40']")).click();//click on rent button

    }
    @When("the user clicks on the rent button")
    public void the_user_clicks_on_the_rent_button() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-40']")).click();//click on rent button
    }
    @Then("the user should navigate to the shopping cart")
    public void the_user_should_navigate_to_the_shopping_cart() {
        driver.findElement(By.xpath("//a[@class='ico-cart']")).click();// click on shopping cart button top right
    }
    @Then("click checkouts as a guest")
    public void click_checkouts_as_a_guest() {
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();//click i agree
        driver.findElement(By.xpath("//button[@id='checkout']")).click();//click checkout
        driver.findElement(By.xpath("//button[contains(.,'Checkout')]")).click();//click checkout as guest
    }
    @Then("complete the checkout by entering in all of the data")
    public void complete_the_checkout_by_entering_in_all_of_the_data() throws InterruptedException {
        WebElement inputs = driver.findElement(By.xpath("//div[@class='edit-address']"));
        inputs.findElement(By.xpath("./*[1]/input")).sendKeys("Elygh"); //first name
        inputs.findElement(By.xpath("./*[2]/input")).sendKeys("Thao");//last name
        inputs.findElement(By.xpath("./*[3]/input")).sendKeys("testy@gmail.com");//email
        inputs.findElement(By.xpath("./*[4]/input")).sendKeys("Elygh Corporation");//company
        Select country = new Select(inputs.findElement(By.xpath("./*[5]/select")));//country
        country.selectByVisibleText("United States");
        Select states = new Select(inputs.findElement(By.xpath("./*[6]/select")));//state
        states.selectByVisibleText("Washington");
        inputs.findElement(By.xpath("./*[7]/input")).sendKeys("Seattle");//city
        inputs.findElement(By.xpath("./*[8]/input")).sendKeys("26235 49th Ave S");//address1
        inputs.findElement(By.xpath("./*[10]/input")).sendKeys("98036");//zip/postal
        inputs.findElement(By.xpath("./*[11]/input")).sendKeys("2064570806");//phone number
        inputs.findElement(By.xpath("./*[12]/input")).sendKeys("N/A");//fax number
        driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();//click continue button

        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();//click continue button

        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();//click on credit card option
        driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();//click continue button

        new Select(driver.findElement(By.xpath("//select[@name='CreditCardType']"))).selectByVisibleText("Master card");//credit card type dropdown
        driver.findElement(By.xpath("//input[@name='CardholderName']")).sendKeys("Elygh Thao");//cardholder name
        driver.findElement(By.xpath("//input[@name='CardNumber']")).sendKeys("206451041651651");//card number
        new Select(driver.findElement(By.xpath("//select[@name='ExpireMonth']"))).selectByVisibleText("10");//expire month
        new Select(driver.findElement(By.xpath("//select[@name='ExpireYear']"))).selectByVisibleText("2027");//expire year
        driver.findElement(By.xpath("//input[@name='CardCode']")).sendKeys("206");//card code
        driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();//click on continue
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();//click confirm button
        String orderNum = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[2]/div[1]/strong")).getText();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[3]/button")).click();//click continue number
        System.out.println(orderNum);
    }

}

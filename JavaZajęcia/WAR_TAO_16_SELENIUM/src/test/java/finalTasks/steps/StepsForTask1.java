package task1Test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import task1Test.LoginPage;
import task1Test.NewAddressPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepsForTask1 {

    WebDriver driver;
    NewAddressPage newAddressPage;
    LoginPage loginPage;

    List <WebElement> deleteLinks;
    WebElement adresssButton;
    WebElement creationButton;
    WebElement lastAdressDelete;
    List <WebElement> addressList;


    @Given("I am on MyStore page")
    public void openMyStorePage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        //czekaj na wprowadzenie danych
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do strony MyStore
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        newAddressPage = new NewAddressPage (driver);
        loginPage = new LoginPage(driver);


    }

    @When("^I go to sign in pannel$")
    //kliknij na przycisk sign in
    public void clickOnSignInButton() { loginPage.clickOnSignInButton();
    }

    @And("^Log in to your account with")
    public void loginCredencials() { loginPage.loginAs();
    }
    @And("Click on Addresses button")
    //kliknij kafelkę adresses
    public void addressButtonClickOn(){
        adresssButton = driver.findElement(By.id("addresses-link"));
        adresssButton.click();
    }

    @And("click on add new address button")
    //kliknij create new adress
    public void newAdressCreation(){
        creationButton = driver.findElement(By.xpath("//*[@data-link-action='add-address']"));
        creationButton.click();
    }
    @And("I fill in alias (.*) field")
    public void alliasFieldInput (String alliasInput){ newAddressPage.inputAllias(alliasInput);
    }
    @And("I fill in address (.*) field")
    public void adressFieldInput(String addressInput){ newAddressPage.fillInAdress(addressInput);
    }
    @And("I fill in city (.*) field")
    public void cityFieldInput(String cityInput) { newAddressPage.fillInCity(cityInput);
    }
    @And("I fill in zip/postalcode (.*)")
    public void postcodeFieldInput(String zip){ newAddressPage.fillInPostcode(zip);
    }
    @And("I fill in phone (.*) field")
    public void phoneNumberFieldInput(String phoneNumber){ newAddressPage.fillInPhoneNumber(phoneNumber);
    }
    @Then("New addres has been created")

    public void submitNewAddress(){ newAddressPage.clickSaveButton();
    }
    @And("Delete last address")
    public void deleteAdress(){

        deleteLinks = driver.findElements(By.xpath("//*[@data-link-action='delete-address']"));
        lastAdressDelete = deleteLinks.get(deleteLinks.size()-1);
        lastAdressDelete.click();
    }

    @And("Check if operation is successful")
    public void getUpdateInformation() {
        WebElement successInformation = driver.findElement(By.cssSelector(" .alert.alert-success"));
        System.out.println(successInformation.getText());
    }
    @And("Data validation (.*) and (.*) and (.*) and (.*)")
    public void isAddressCorrect(String adress, String city, String zip, String phone) {
        addressList = driver.findElements(By.xpath("//address"));

        WebElement lastAddedAddress = addressList.get(addressList.size() - 1);

        Assert.assertTrue(lastAddedAddress.getText().contains(adress));
        Assert.assertTrue(lastAddedAddress.getText().contains(city));
        Assert.assertTrue(lastAddedAddress.getText().contains(zip));
        Assert.assertTrue(lastAddedAddress.getText().contains(phone));
    }
    @And("close window")
    public void closeBrowser() throws Exception{

        Thread.sleep(2000);
        driver.quit();
    }

}
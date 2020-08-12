package finalTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddressPage {

    WebDriver driver;

    public NewAddressPage(WebDriver driver){
        this.driver = driver;
    }

    // pobierz i uzupełnij pole allias
    public void inputAllias(String alliasInput){
        WebElement allias = driver.findElement(By.name("alias"));
        allias.sendKeys(alliasInput);
    }
    // pobierz i uzupełnij pole address
    public void fillInAdress(String addressInput){
        WebElement adress = driver.findElement(By.name("address1"));
        adress.sendKeys(addressInput);
    }
    // pobierz i uzupełnij pole city
    public void fillInCity(String cityInput) {
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys(cityInput);
    }
    //pobierz i uzupełnij pole zip/postalcode
    public void fillInPostcode(String zip){
        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys(zip);
    }
    // pobierz i uzupełnij pole phone
    public void fillInPhoneNumber(String phoneNumber){
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(phoneNumber);
    }
    //kliknij przycisk zapisz
    public void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
        saveButton.click();
    }
}

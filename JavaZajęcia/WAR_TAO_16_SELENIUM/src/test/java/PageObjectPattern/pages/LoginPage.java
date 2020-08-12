package PageObjectPattern;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


    public class LoginPage {
        private static WebDriver driver;
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }
    }

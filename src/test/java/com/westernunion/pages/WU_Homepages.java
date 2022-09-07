package com.westernunion.pages;

import com.westernunion.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class WU_Homepages {

    public WU_Homepages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='hamburger-button']")
    public WebElement burgerMenu;

    @FindBy(xpath = "(//a[@title='Close Message'])[2]")
    public WebElement closeButton;

    @FindBy(xpath = "//li[@class='nav-item']/a[@href='/lt/en/account/app/settings']")
    public WebElement settings;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//ul[@class=\"nav-dropdown wu-header__dropdown__items\"]//a[@href='/lt/en/find-locations.html']")
    public WebElement findLocation;

    @FindBy(xpath = "(//div[@class=\"wu_Filters2_Item___3KLbH\"])[1]")
    public WebElement openNowButton;

    @FindBy(xpath = "//iframe[@src=\"//locations.westernunion.com/?iframe=true&locale=en_LT\"]")
    public WebElement Iframe;

    public String getAddress(){
        List<WebElement> getAddress=Driver.getDriver().findElements(By.className("wu_LocationCard_AddressLine___3sU8t"));
        String address = "";
        if (getAddress.size()==0){
           System.out.println("Sorry, there is no open agent right now");
       }else {
        address=getAddress.get(0).getText()+" "+getAddress.get(1).getText();

       }return address;
    }

}

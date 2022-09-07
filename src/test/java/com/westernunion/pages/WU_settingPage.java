package com.westernunion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WU_settingPage extends WU_Homepages{


    @FindBy(xpath = "//select[@id=\"Question\"]")
    public WebElement dropdown;

    @FindBy(xpath = "(//translate[text()='Yes'])[1]")
    public WebElement yesButton;

}

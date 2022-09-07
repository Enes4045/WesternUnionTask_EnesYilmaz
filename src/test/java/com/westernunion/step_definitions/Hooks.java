package com.westernunion.step_definitions;


import com.westernunion.utilities.ConfigurationReader;
import com.westernunion.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

//in the class we will be able to pass pre-&post-conditions to each scenario and each step

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        String url= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void teardownScenario(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

       Driver.closeDriver();
    }}
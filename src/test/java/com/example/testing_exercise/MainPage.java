package com.example.testing_exercise;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement searchButton = $x("/html/body/div/div/div[2]/div/div/div/div/form/button");
    public SelenideElement regEntry = $x("/html/body/div/div/div[2]/div/div/div/div/form/div[1]/input");
    public SelenideElement error = $x("/html/body/div/div/div[2]/div[11]");
    public SelenideElement vehicleMake= $x("/html/body/div/div/div[2]/div[4]/div[1]/div/span/div[2]/dl[2]/dd");
    public SelenideElement vehicleModel= $x("/html/body/div/div/div[2]/div[4]/div[1]/div/span/div[2]/dl[3]/dd");
    public SelenideElement vehicleColour= $x("/html/body/div/div/div[2]/div[4]/div[1]/div/span/div[2]/dl[4]/dd");
    public SelenideElement vehicleYear= $x("/html/body/div/div/div[2]/div[4]/div[1]/div/span/div[2]/dl[5]/dd");
}

package com.example.testing_exercise.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement searchButton = $("#m > div.jsx-3972257182.m-w-1.d-w-1.p-w-1 > div > div > div > div > form > button");
    public SelenideElement regEntry = $("#vrm-input");
    public SelenideElement sale = $("#checkout-form > div.jsx-3499070155");
    public SelenideElement vehicleMake= $("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd");
    public SelenideElement vehicleModel= $("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd");
    public SelenideElement vehicleColour= $("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd");
    public SelenideElement vehicleYear= $("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd");
    public SelenideElement vehicleMakeSale= $("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd");
    public SelenideElement vehicleModelSale= $("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd");
    public SelenideElement vehicleColourSale= $("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd");
    public SelenideElement vehicleYearSale= $("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd");
}

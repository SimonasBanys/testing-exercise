package com.example.testing_exercise;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    MainPage mainPage = new MainPage();
    static ArrayList<Car> carsInput = new ArrayList<>();
    static ArrayList<Car> carsCheck = new ArrayList<>();

    @Before
    public void setUpAll() throws IOException {
        Configuration.browserSize = "1280x800";
        String inputRead = readFile("car_input.txt");
        String toLookFor = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";
        String[] plates = getAllPlates(inputRead, toLookFor);
        for (String s : plates){
            carsInput.add(new Car(s));
        }
        String compareRead = readFile("car_output.txt");
        getCompare(compareRead,toLookFor);
    }

    static String readFile(String filename) throws IOException{
        FileReader reader = new FileReader(filename);
        int data;
        String readerInput = "";
        while ((data=reader.read()) != -1){
            readerInput += (char) data;
        }
        reader.close();
        return readerInput;
    }

    static String[] getAllPlates(String in, String regex){
        String[] matches = Pattern.compile(regex)
                .matcher(in.toUpperCase())
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        for (int i = 0; i < matches.length; i++){
            matches[i] = matches[i].replace(" ","");
        }
        return matches;
    }

    static void getCompare(String in, String regex){
        String[] vehicles = in.split("\\r?\\n");
        String[] vehicleDetails;
        for (int i = 1; i < vehicles.length; i++){
            vehicleDetails = vehicles[i].split("\\,");
            carsCheck.add(new Car(vehicleDetails[0], vehicleDetails[1], vehicleDetails[2],vehicleDetails[3],
                    (int)Double.parseDouble(vehicleDetails[4])));
        }
    }



    @When("user goes to the website and uses car {int}")
    public void userGoesToTheWebsiteAndUsesCarIndex(int index) {
        open("https://cartaxcheck.co.uk/");
        mainPage.regEntry.setValue(carsInput.get(index).getRegistration());
        mainPage.searchButton.click();
        mainPage.error.shouldNotBe(visible, Duration.ofSeconds(15));
        mainPage.vehicleMake.shouldNotBe(empty, Duration.ofSeconds(5));
        carsInput.get(index).setMake(mainPage.vehicleMake.getText());
        mainPage.vehicleModel.shouldNotBe(empty, Duration.ofSeconds(5));
        carsInput.get(index).setModel(mainPage.vehicleModel.getText());
        mainPage.vehicleColour.shouldNotBe(empty, Duration.ofSeconds(5));
        carsInput.get(index).setColour(mainPage.vehicleColour.getText());
        mainPage.vehicleYear.shouldNotBe(empty, Duration.ofSeconds(5));
        carsInput.get(index).setYear(Integer.parseInt(mainPage.vehicleYear.getText()));
        System.out.println(carsInput.get(index).getMake());
    }

    @Then("user checks if the car {int} exists in the list")
    public void userChecksIfTheCarIndexExistsInTheList(int index) {
        assertTrue(carsCheck.contains(carsInput.get(index)));
    }

    @Then("user checks if the car {int} is the same in input and output")
    public void userChecksIfTheCarIndexIsTheSameInInputAndOutput(int index) {
        assertTrue(carsCheck.get(index).equals(carsInput.get(index)));
    }
}

package com.example.testing_exercise;

import com.codeborne.selenide.Configuration;
import com.example.testing_exercise.utils.Car;
import com.example.testing_exercise.utils.MainPage;
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
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    MainPage mainPage = new MainPage();
    ArrayList<Car> carsInput = new ArrayList<>();
    ArrayList<Car> carsOutput = new ArrayList<>();

    /*
     *  A setup method to be used before all the tests
     *
     *  toLookFor   defines the format of registration plates to be checked for in input/output files
     *              different formats would need to be defined in a different regex variable
     */
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

    /*
     *  Method created for re-usability between car_input.txt and car_output.txt reading.
     *
     * @param fileName  the name of the file to be read
     * @return produces the read file in a string format.
     */
    String readFile(String fileName) throws IOException{
        FileReader reader = new FileReader(fileName);
        int data;
        String readerInput = "";
        while ((data=reader.read()) != -1){
            readerInput += (char) data;
        }
        reader.close();
        return readerInput;
    }

    /*
     *  This method would allow re-usability for different formats of registration numbers
     *  A given text input
     * @param input would define the string of characters to be checked for licence plates
     * @param regex the registration plate format to be checked for
     *
     * by providing different types of formats this would allow any standard licence plates to be discovered.
     */
    String[] getAllPlates(String input, String regex){
        String[] matches = Pattern.compile(regex)
                .matcher(input.toUpperCase())
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        for (int i = 0; i < matches.length; i++){
            matches[i] = matches[i].replace(" ","");
        }
        return matches;

    }

    /*
        An assumption here was made that all vehicles will be defined in the same format regardless of the amount or future files
        {registration number, make, model, colour, year}
     */
    void getCompare(String in, String regex){
        String[] vehicles = in.split("\\r?\\n");
        String[] vehicleDetails;
        for (int i = 1; i < vehicles.length; i++){
            vehicleDetails = vehicles[i].split(",");
            carsOutput.add(new Car(vehicleDetails[0], vehicleDetails[1], vehicleDetails[2],vehicleDetails[3],
                    (int)Double.parseDouble(vehicleDetails[4])));
        }

    }


    /*
        at this point can be better optimised.
     */
    @When("user goes to the website and uses car {int}")
    public void userGoesToTheWebsiteAndUsesCarIndex(int index) {
        open("https://cartaxcheck.co.uk/");
        mainPage.regEntry.setValue(carsInput.get(index).getRegistration());
        mainPage.searchButton.click();
        if (!mainPage.sale.isDisplayed()){
            mainPage.vehicleMake.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setMake(mainPage.vehicleMake.getText());
            mainPage.vehicleModel.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setModel(mainPage.vehicleModel.getText());
            mainPage.vehicleColour.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setColour(mainPage.vehicleColour.getText());
            mainPage.vehicleYear.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setYear(Integer.parseInt(mainPage.vehicleYear.getText()));
        } else {
            mainPage.vehicleMakeSale.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setMake(mainPage.vehicleMakeSale.getText());
            mainPage.vehicleModelSale.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setModel(mainPage.vehicleModelSale.getText());
            mainPage.vehicleColourSale.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setColour(mainPage.vehicleColourSale.getText());
            mainPage.vehicleYearSale.shouldNotBe(empty, Duration.ofSeconds(5));
            carsInput.get(index).setYear(Integer.parseInt(mainPage.vehicleYearSale.getText()));
        }
        System.out.println(carsInput.get(index).getMake());
    }

    @Then("user checks if the car {int} exists in the list")
    public void userChecksIfTheCarIndexExistsInTheList(int index) {
        assertTrue(carsOutput.contains(carsInput.get(index)));
    }

    @Then("user checks if car {int} has been repainted")
    public void userChecksIfCarIndexHasBeenRepainted(int index) {
        for (Car c : carsOutput){
            if (c.getRegistration().equals(carsInput.get(index).getRegistration())){
                assertEquals(c.getColour(),carsInput.get(index).getColour());
            }
        }
    }

    @Then("user checks if car {int} make is the same")
    public void userChecksIfCarIndexMakeIsTheSame(int index) {
        for (Car c : carsOutput){
            if (c.getRegistration().equals(carsInput.get(index).getRegistration())){
                assertEquals(c.getMake(),carsInput.get(index).getMake());
            }
        }
    }

    @Then("user checks if car {int} model is the same")
    public void userChecksIfCarIndexModelIsTheSame(int index) {
        for (Car c : carsOutput){
            if (c.getRegistration().equals(carsInput.get(index).getRegistration())){
                assertEquals(c.getModel(),carsInput.get(index).getModel());
            }
        }
    }

    @Then("user checks if car {int} colour is the same")
    public void userChecksIfCarIndexColourIsTheSame(int index) {
        for (Car c : carsOutput){
            if (c.getRegistration().equals(carsInput.get(index).getRegistration())){
                assertEquals(c.getColour(),carsInput.get(index).getColour());
            }
        }
    }

    @Then("user checks if car {int} year is the same")
    public void userChecksIfCarIndexYearIsTheSame(int index) {
        for (Car c : carsOutput){
            if (c.getRegistration().equals(carsInput.get(index).getRegistration())){
                assertEquals(c.getYear(),carsInput.get(index).getYear());
            }
        }
    }
}

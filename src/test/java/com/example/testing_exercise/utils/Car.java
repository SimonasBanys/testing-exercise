package com.example.testing_exercise.utils;

import java.util.Objects;

public class Car {

    private String registration;
    private String make;
    private String model;
    private String colour;
    private int year;

    public Car(){
        this.registration = "";
        this.make = "";
        this.model = "";
        this.colour = "";
        this.year = 0;
    }

    public Car(String reg){
        this.registration = reg;
        this.make = "";
        this.model = "";
        this.colour = "";
        this.year = 0;
    }

    public Car(String reg, String make, String model, String colour, int year){
        this.registration = reg;
        this.year = year;
        this.colour = colour;
        this.model= model;
        this.make = make;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Car)){
            return false;
        }
        Car test = (Car) o;
        return (test.registration.equals(this.registration)) && (test.colour.equals(this.colour))
                && (test.make.equals(this.make)) && (test.model.equals(this.model))
                && (test.year == this.year);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.registration,this.colour,this.make,this.model,this.year);
    }
}

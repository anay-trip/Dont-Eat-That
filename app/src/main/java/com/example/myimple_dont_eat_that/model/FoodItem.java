package com.example.myimple_dont_eat_that.model;

public class FoodItem { 

    int id;
    String name;
    double calories, carbs, protein, fat, cholestrol;
    //constructor
    public FoodItem(int id, String name, double calories, double carbs, double protein, double fat, double cholestrol) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.cholestrol = cholestrol;
    }

    public FoodItem() {
    }

    //getter and setter methods for all attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(double cholestrol) {
        this.cholestrol = cholestrol;
    }
}

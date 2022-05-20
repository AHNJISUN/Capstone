package com.example.capstoneapp;

public class PetData {
    private String petName;
    private String petbreed;
    private String petGender;
    private String petAge;
    private String petNeutering;
    private String petFood;
    private String petIdCard;
    private String petMedi;
    private String petinoculation;

    public PetData(String petName, String petbreed, String petGender, String petAge, String petNeutering, String petFood, String petIdCard, String petMedi, String petinoculation) {
        this.petName = petName;
        this.petbreed = petbreed;
        this.petGender = petGender;
        this.petAge = petAge;
        this.petNeutering = petNeutering;
        this.petFood = petFood;
        this.petIdCard = petIdCard;
        this.petMedi = petMedi;
        this.petinoculation = petinoculation;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetbreed() {
        return petbreed;
    }

    public void setPetbreed(String petbreed) {
        this.petbreed = petbreed;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetNeutering() {
        return petNeutering;
    }

    public void setPetNeutering(String petNeutering) {
        this.petNeutering = petNeutering;
    }

    public String getPetFood() {
        return petFood;
    }

    public void setPetFood(String petFood) {
        this.petFood = petFood;
    }

    public String getPetIdCard() {
        return petIdCard;
    }

    public void setPetIdCard(String petIdCard) {
        this.petIdCard = petIdCard;
    }

    public String getPetMedi() {
        return petMedi;
    }

    public void setPetMedi(String petMedi) {
        this.petMedi = petMedi;
    }

    public String getPetinoculation() {
        return petinoculation;
    }

    public void setPetinoculation(String petinoculation) {
        this.petinoculation = petinoculation;
    }
}

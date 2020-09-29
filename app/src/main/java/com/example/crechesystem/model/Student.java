package com.example.crechesystem.model;

public class Student {
    int image;
    String id;
    String name;
    String surname;
    String gender;
    String address;
    String allergies;

    public Student(String id, String name, String surname, String gender, String address, String allergies, String classGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.allergies = allergies;
        this.classGroup = classGroup;
    }

    public Student(){}

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    String classGroup;
}

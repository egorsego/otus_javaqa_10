package com.otus.testdata;

import java.util.ArrayList;
import java.util.Arrays;

public class UserAccount {
    public String firstName;
    public String firstNameLatin;
    public String lastName;
    public String lastNameLatin;
    public String blogName;
    public String birthDate;
    public String country;
    public String city;
    public String isReadyForRelocation;
    public ArrayList<String> workSchedule;
    public Contact contactOne;
    public Contact contactTwo;
    public String gender;
    public String company;
    public String position;

    public void init(){
        firstName = "Эммет";
        firstNameLatin = "Emmet";
        lastName = "Браун";
        lastNameLatin = "Brown";
        blogName = "Doc.";
        birthDate = "20.10.1950";
        country = "Россия";
        city = "Александров";
        isReadyForRelocation = "Да";
        workSchedule = new ArrayList<>(Arrays.asList("Полный день", "Удаленно", "Гибкий график"));
        gender = "Мужской";
        contactOne = new Contact("VK", "VK Account");
        contactTwo = new Contact("WhatsApp", "9991001010");
        company = "Self Employed";
        position = "Mad scientist";
    }
}

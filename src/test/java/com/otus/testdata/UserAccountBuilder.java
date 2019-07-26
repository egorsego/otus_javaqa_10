package com.otus.testdata;

import java.util.ArrayList;

public class UserAccountBuilder {
    private UserAccount userAccount = new UserAccount();

    public UserAccountBuilder withFirstName(String name){
        userAccount.firstName = name;
        return this;
    }

    public UserAccountBuilder withFirstNameLatin(String name){
        userAccount.firstNameLatin = name;
        return this;
    }

    public UserAccountBuilder withLastName(String name){
        userAccount.lastName = name;
        return this;
    }

    public UserAccountBuilder withLastNameLatin(String name){
        userAccount.lastNameLatin = name;
        return this;
    }

    public UserAccountBuilder withBlogName(String name){
        userAccount.blogName = name;
        return this;
    }

    public UserAccountBuilder withBirthDate(String date){
        userAccount.birthDate = date;
        return this;
    }

    public UserAccountBuilder livingInCountry(String country){
        userAccount.country = country;
        return this;
    }

    public UserAccountBuilder livingInCity(String city){
        userAccount.city = city;
        return this;
    }

    public UserAccountBuilder isReadyForRelocation(String readiness){
        userAccount.isReadyForRelocation = readiness;
        return this;
    }

    public UserAccountBuilder withWorkSchedule(ArrayList<String> schedule){
        userAccount.workSchedule = schedule;
        return this;
    }

    public UserAccountBuilder withPrimaryContact(Contact contact){
        userAccount.contactOne = contact;
        return this;
    }

    public UserAccountBuilder withSecondaryContact(Contact contact){
        userAccount.contactTwo = contact;
        return this;
    }

    public UserAccountBuilder withGender(String gender){
        userAccount.gender = gender;
        return this;
    }

    public UserAccountBuilder withCompany(String company){
        userAccount.company = company;
        return this;
    }

    public UserAccountBuilder withPosition(String position){
        userAccount.position = position;
        return this;
    }

    public UserAccount build(){
        return userAccount;
    }
}

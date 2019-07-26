package com.otus.testdata;

import com.otus.utils.Utilities;

import java.util.ArrayList;

public class UserAccount {
    protected String firstName;
    protected String firstNameLatin;
    protected String lastName;
    protected String lastNameLatin;
    protected String blogName;
    protected String birthDate;
    protected String country;
    protected String city;
    protected String isReadyForRelocation;
    protected ArrayList<String> workSchedule;
    protected Contact contactOne;
    protected Contact contactTwo;
    protected String gender;
    protected String company;
    protected String position;

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != this.getClass())
            return false;

        UserAccount userAccount = (UserAccount) obj;
        return userAccount.firstName.equals(this.firstName) &&
                userAccount.firstNameLatin.equals(this.firstNameLatin) &&
                userAccount.lastName.equals(this.lastName) &&
                userAccount.lastNameLatin.equals(this.lastNameLatin) &&
                userAccount.blogName.equals(this.blogName) &&
                userAccount.birthDate.equals(this.birthDate) &&
                userAccount.country.equals(this.country) &&
                userAccount.city.equals(this.city) &&
                userAccount.isReadyForRelocation.equals(this.isReadyForRelocation) &&
                Utilities.areEqualArrays(userAccount.workSchedule, this.workSchedule) &&
                userAccount.contactOne.equals(this.contactOne) &&
                userAccount.contactTwo.equals(this.contactTwo) &&
                userAccount.gender.equals(this.gender) &&
                userAccount.company.equals(this.company) &&
                userAccount.position.equals(this.position);
    }

    @Override
    public int hashCode()
    {
        String concat = firstName +
                firstNameLatin +
                lastName +
                lastNameLatin +
                blogName +
                birthDate +
                country +
                city +
                isReadyForRelocation +
                workSchedule +
                contactOne +
                contactTwo +
                gender +
                company +
                position;
        return concat.hashCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getIsReadyForRelocation() {
        return isReadyForRelocation;
    }

    public ArrayList<String> getWorkSchedule() {
        return workSchedule;
    }

    public Contact getContactOne() {
        return contactOne;
    }

    public Contact getContactTwo() {
        return contactTwo;
    }

    public String getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }
}

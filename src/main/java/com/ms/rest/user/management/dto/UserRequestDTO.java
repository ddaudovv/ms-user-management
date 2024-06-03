package com.ms.rest.user.management.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class UserRequestDTO {
    @NotEmpty(message = "First name can not be empty.")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty.")
    private String lastName;

    @NotEmpty(message = "Date of birth can not be empty.")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Phone number can not be empty.")
    private String phoneNumber;

    @NotEmpty(message = "Email address can not be empty.")
    private String emailAddress;


    public UserRequestDTO() {
    }

    public UserRequestDTO(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

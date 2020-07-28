package com.solvd.automation.lab.carina.demo.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureAuthor {
    private String id;
    private String IDBook;
    private String firstName;
    private String lastName;


    public AzureAuthor(){};

    public AzureAuthor(String IDBook, String firstName, String lastName) {
        this.IDBook = IDBook;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @JsonCreator
    public AzureAuthor(
            @JsonProperty("ID") String id,
            @JsonProperty("IDBook") String IDBook,
            @JsonProperty("FirstName") String firstName,
            @JsonProperty("LastName") String lastName

    ) {
        this.id = id;
        this.IDBook = IDBook;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIDBook() {
        return IDBook;
    }

    public void setIDBook(String IDBook) {
        this.IDBook = IDBook;
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
}

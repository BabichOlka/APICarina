package com.solvd.automation.lab.carina.demo.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class AzureCoverPhoto {
    private String id;
    private String idBook;
    private String url;

    @JsonCreator
    public AzureCoverPhoto(
            @JsonProperty("ID") String id,
            @JsonProperty("IDBook") String idBook,
            @JsonProperty("Url") String url
    ) {
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public AzureCoverPhoto(){

    };


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
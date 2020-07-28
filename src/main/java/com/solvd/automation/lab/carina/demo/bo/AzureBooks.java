package com.solvd.automation.lab.carina.demo.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AzureBooks {
    private String id;
    private String title;
    private String description;
    private String pageCount;
    private String excerpt;
    private String publishDate;

    public AzureBooks(){};

    public AzureBooks(String title, String description, String pageCount,
                      String excerpt, String publishDate) {
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    @JsonCreator
    public AzureBooks(
            @JsonProperty("ID") String id,
            @JsonProperty("Title") String title,
            @JsonProperty("Description") String description,
            @JsonProperty("PageCount") String pageCount,
            @JsonProperty("Excerpt") String excerpt,
            @JsonProperty("PublishDate") String publishDate

    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}

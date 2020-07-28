package com.solvd.automation.lab.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PostAzureBooksMethod extends AbstractApiMethodV2 {
    public PostAzureBooksMethod(AzureBooks azureBook) {
        super("api.azure_books\\_post\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("title", azureBook.getTitle());
        addProperty("description", azureBook.getDescription());
        addProperty("pageCount", azureBook.getPageCount());
        addProperty("excerpt", azureBook.getExcerpt());
        addProperty("publishDate", azureBook.getPublishDate());

    }
}

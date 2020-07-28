package com.solvd.automation.lab.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PutAzureBooksByIdMethod extends AbstractApiMethodV2 {
    public PutAzureBooksByIdMethod(AzureBooks azureBook) {
        super("api.azure_books\\_put\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", azureBook.getId());
        addProperty("title", azureBook.getTitle());
        addProperty("description", azureBook.getDescription());
        addProperty("pageCount", azureBook.getPageCount());
        addProperty("excerpt", azureBook.getExcerpt());
        addProperty("publishDate", azureBook.getPublishDate());
        addProperty("id",azureBook.getId());
    }
}

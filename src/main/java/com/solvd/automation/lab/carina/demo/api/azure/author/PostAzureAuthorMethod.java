package com.solvd.automation.lab.carina.demo.api.azure.author;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PostAzureAuthorMethod extends AbstractApiMethodV2 {
    public PostAzureAuthorMethod(AzureAuthor azureAuthor) {
        super("api.azure_author\\_post\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("IDBook", azureAuthor.getIDBook());
        addProperty("firstName", azureAuthor.getFirstName());
        addProperty("lastName", azureAuthor.getLastName());


    }
}

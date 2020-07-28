package com.solvd.automation.lab.carina.demo.api.azure.author;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PutAzureAuthorByIdMethod extends AbstractApiMethodV2 {
    public PutAzureAuthorByIdMethod(AzureAuthor azureAuthor) {
        super("api.azure_author\\_put\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", azureAuthor.getId());
        addProperty("IDBook", azureAuthor.getIDBook());
        addProperty("firstName", azureAuthor.getFirstName());
        addProperty("lastName", azureAuthor.getLastName());
        addProperty("id",azureAuthor.getId());
    }
}

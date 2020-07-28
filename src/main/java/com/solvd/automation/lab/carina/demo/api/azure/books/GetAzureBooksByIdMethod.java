package com.solvd.automation.lab.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class GetAzureBooksByIdMethod extends AbstractApiMethodV2 {
    public GetAzureBooksByIdMethod(AzureBooks azureBooks){
        super(null, "api\\azure_books\\_get\\rsId.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id",azureBooks.getId());


    }
}

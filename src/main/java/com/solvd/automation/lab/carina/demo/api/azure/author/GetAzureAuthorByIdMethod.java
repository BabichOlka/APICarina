package com.solvd.automation.lab.carina.demo.api.azure.author;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class GetAzureAuthorByIdMethod extends AbstractApiMethodV2 {
    public GetAzureAuthorByIdMethod(AzureAuthor azureAuthor){
        super(null, "api\\azure_author\\_get\\rsId.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id",azureAuthor.getId());


    }
}

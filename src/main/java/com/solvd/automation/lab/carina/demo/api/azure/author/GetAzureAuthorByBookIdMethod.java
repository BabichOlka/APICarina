package com.solvd.automation.lab.carina.demo.api.azure.author;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;

import java.util.Properties;

public class GetAzureAuthorByBookIdMethod extends AbstractApiMethodV2 {
    public GetAzureAuthorByBookIdMethod(int IDBook){
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("idBook",String.valueOf(IDBook));


    }
}

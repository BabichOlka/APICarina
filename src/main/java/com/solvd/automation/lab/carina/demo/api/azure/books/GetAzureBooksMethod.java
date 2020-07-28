package com.solvd.automation.lab.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureBooksMethod extends AbstractApiMethodV2 {
    public GetAzureBooksMethod(){
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));


    }
}

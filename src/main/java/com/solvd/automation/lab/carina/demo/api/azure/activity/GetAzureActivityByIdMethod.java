package com.solvd.automation.lab.carina.demo.api.azure.activity;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureActivity;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class GetAzureActivityByIdMethod extends AbstractApiMethodV2 {
    public GetAzureActivityByIdMethod(AzureActivity azureActivity){
        super(null, "api\\azure_activity\\_get\\rsId.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id",String.valueOf(azureActivity.getId()));


    }
}

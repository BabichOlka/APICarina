package com.solvd.automation.lab.carina.demo.api.azure.activity;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureActivity;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PostAzureActivityMethod extends AbstractApiMethodV2 {
    public PostAzureActivityMethod(AzureActivity azureActivity) {
        super("api.azure_activity\\_post\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("title", azureActivity.getTitle());
        addProperty("dueDate", azureActivity.getDueDate());
        addProperty("completed", azureActivity.getCompleted());


    }
}
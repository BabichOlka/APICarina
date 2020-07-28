package com.solvd.automation.lab.carina.demo.api.azure.activity;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureActivity;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;

import java.util.Properties;

public class PutAzureActivityByIdMethod extends AbstractApiMethodV2 {
    public PutAzureActivityByIdMethod(AzureActivity azureActivity) {
        super("api.azure_activity\\_put\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", String.valueOf(azureActivity.getId()));
        addProperty("title", azureActivity.getTitle());
        addProperty("dueDate", azureActivity.getDueDate());
        addProperty("completed", azureActivity.getCompleted());
        addProperty("id",azureActivity.getId());
    }
}

package com.solvd.automation.lab.carina.demo.api.azure.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureUser;

import java.util.Properties;

public class PutAzureUserByIdMethod extends AbstractApiMethodV2 {
    public PutAzureUserByIdMethod(AzureUser azureUser) {
        super("api\\azure_users\\_put\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", azureUser.getId());
        addProperty("username", azureUser.getUsername());
        addProperty("password", azureUser.getPassword());
        addProperty("id",azureUser.getId());
    }
}

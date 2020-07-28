package com.solvd.automation.lab.carina.demo.api.azure.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureUser;

import java.util.Properties;

public class PostAzureUserMethod extends AbstractApiMethodV2 {
    public PostAzureUserMethod(AzureUser azureUser) {
        super("api\\azure_users\\_post\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("username", azureUser.getUsername());
        addProperty("password", azureUser.getPassword());
    }
}

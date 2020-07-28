package com.solvd.automation.lab.carina.demo.api.azure.activity;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeleteAzureActivityByIdMethod extends AbstractApiMethodV2 {
    public DeleteAzureActivityByIdMethod(int id) {
        super(null, "api\\azure_activity\\_delete\\rs.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));

    }
}

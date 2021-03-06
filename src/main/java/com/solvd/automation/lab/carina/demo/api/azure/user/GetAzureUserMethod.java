package com.solvd.automation.lab.carina.demo.api.azure.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureUserMethod extends AbstractApiMethodV2 {
    public GetAzureUserMethod(){
        super(null, "api\\azure_users\\_get\\rs.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));


    }
}

package com.solvd.automation.lab.carina.demo.api.azure.author;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeleteAzureAuthorByIdMethod extends AbstractApiMethodV2 {
    public DeleteAzureAuthorByIdMethod(int id) {
        super(null, "api\\azure_author\\_delete\\rs.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));

    }
}

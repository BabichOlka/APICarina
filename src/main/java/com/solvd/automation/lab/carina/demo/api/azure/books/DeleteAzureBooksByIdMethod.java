package com.solvd.automation.lab.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeleteAzureBooksByIdMethod extends AbstractApiMethodV2 {
    public DeleteAzureBooksByIdMethod(int id) {
        super(null, "api\\azure_books\\_delete\\rs.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));

    }
}

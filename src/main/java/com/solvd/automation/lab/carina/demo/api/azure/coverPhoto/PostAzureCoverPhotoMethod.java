package com.solvd.automation.lab.carina.demo.api.azure.coverPhoto;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureCoverPhoto;

import java.util.Properties;

public class PostAzureCoverPhotoMethod extends AbstractApiMethodV2 {
    public PostAzureCoverPhotoMethod(AzureCoverPhoto azureCoverPhoto) {
        super("api.azure_coverPhoto\\_post\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("IDBook", azureCoverPhoto.getIdBook());
        addProperty("url", azureCoverPhoto.getUrl());


    }
}

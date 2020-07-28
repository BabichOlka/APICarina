package com.solvd.automation.lab.carina.demo.api.azure.coverPhoto;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureCoverPhoto;

import java.util.Properties;

public class PutAzureCoverPhotoByIdMethod extends AbstractApiMethodV2 {
    public PutAzureCoverPhotoByIdMethod(AzureCoverPhoto azureCoverPhoto) {
        super("api.azure_coverPhoto\\_put\\rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", azureCoverPhoto.getId());
        addProperty("IDBook", azureCoverPhoto.getIdBook());
        addProperty("url", azureCoverPhoto.getUrl());
        addProperty("id",azureCoverPhoto.getId());
    }
}

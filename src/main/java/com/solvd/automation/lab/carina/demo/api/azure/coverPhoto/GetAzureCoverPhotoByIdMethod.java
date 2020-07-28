package com.solvd.automation.lab.carina.demo.api.azure.coverPhoto;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.automation.lab.carina.demo.bo.AzureCoverPhoto;

import java.util.Properties;

public class GetAzureCoverPhotoByIdMethod extends AbstractApiMethodV2 {
    public GetAzureCoverPhotoByIdMethod(AzureCoverPhoto azureCoverPhoto){
        super(null, "api\\azure_coverPhoto\\_get\\rsId.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id",azureCoverPhoto.getId());


    }
}

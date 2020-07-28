package com.solvd.automation.lab.carina.demo.api.azure.coverPhoto;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureCoverPhotoByBookIdMethod extends AbstractApiMethodV2 {
    public GetAzureCoverPhotoByBookIdMethod(int IDBook){
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("idBook",String.valueOf(IDBook));


    }
}

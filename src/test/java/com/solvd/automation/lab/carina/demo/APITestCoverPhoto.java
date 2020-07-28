/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solvd.automation.lab.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.lab.carina.demo.api.azure.coverPhoto.*;
import com.solvd.automation.lab.carina.demo.bo.AzureCoverPhoto;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestCoverPhoto {

    private static final Logger LOGGER = Logger.getLogger(APITestCoverPhoto.class);


    @MethodOwner(owner = "babich")
    @Test
    public void testCreateAzureCoverPhoto() throws Exception{

        String id = "1";
        String idBook = "1";
        String url = "URL";
        AzureCoverPhoto azureCoverPhoto = new AzureCoverPhoto(id,idBook,url);

        PostAzureCoverPhotoMethod postAzureCoverPhotoMethod =
                new PostAzureCoverPhotoMethod(azureCoverPhoto);
        postAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureCoverPhotoMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureCoverPhoto actualCoverPhoto = mapper.readValue(rs, AzureCoverPhoto.class);

        Assert.assertNotNull(actualCoverPhoto, "Response object cannot be null!");
        Assert.assertEquals(actualCoverPhoto.getIdBook(), azureCoverPhoto.getIdBook(), "IDBook is not as expected!");
        Assert.assertEquals(actualCoverPhoto.getUrl(), azureCoverPhoto.getUrl(), "URL is not as expected!");


    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureCoverPhoto() throws Exception{

        GetAzureCoverPhotoMethod getAzureCoverPhotoMethod = new  GetAzureCoverPhotoMethod();
        getAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoMethod.callAPI();

       getAzureCoverPhotoMethod.validateResponseAgainstSchema("api.azure_coverPhoto\\_get\\rs.schema");
    }

    @MethodOwner(owner = "babich")
    @Test
    public void testDeleteAzureCoverPhoto() throws Exception{
        int id = 1;
        DeleteAzureCoverPhotoByIdMethod deleteAzureCoverPhotoMethod = new  DeleteAzureCoverPhotoByIdMethod(id);
        deleteAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureCoverPhotoMethod.callAPI();

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureCoverPhotoById() throws Exception{
        int id = 1;
        AzureCoverPhoto azureCoverPhoto = new AzureCoverPhoto();
        azureCoverPhoto.setId(String.valueOf(id));

        GetAzureCoverPhotoByIdMethod getAzureCoverPhotoMethod = new  GetAzureCoverPhotoByIdMethod(azureCoverPhoto);
        getAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoMethod.callAPI();

        String rs = getAzureCoverPhotoMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureCoverPhoto actualCoverPhoto = mapper.readValue(rs, AzureCoverPhoto.class);

        Assert.assertNotNull(actualCoverPhoto, "Response object cannot be null!");
        Assert.assertEquals(actualCoverPhoto.getId(), azureCoverPhoto.getId(), "Id is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testPutAzureCoverPhotoById() throws Exception{

        String id = "1";
        String idBook = "1";
        String url = "URL";
        AzureCoverPhoto azureCoverPhoto = new AzureCoverPhoto(id,idBook,url);

        PutAzureCoverPhotoByIdMethod putAzureCoverPhotoMethod =
                new PutAzureCoverPhotoByIdMethod(azureCoverPhoto);
        putAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureCoverPhotoMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureCoverPhoto actualCoverPhoto = mapper.readValue(rs, AzureCoverPhoto.class);


        Assert.assertNotNull(actualCoverPhoto, "Response object cannot be null!");
        Assert.assertEquals(actualCoverPhoto.getIdBook(), azureCoverPhoto.getIdBook(), "IDBook is not as expected!");
        Assert.assertEquals(actualCoverPhoto.getUrl(), azureCoverPhoto.getUrl(), "URL is not as expected!");


    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureCoverPhotoByBookId() throws Exception{
        int IDBook = 1;
        AzureCoverPhoto azureCoverPhoto = new AzureCoverPhoto();
        azureCoverPhoto.setId(String.valueOf(IDBook));

        GetAzureCoverPhotoByBookIdMethod getAzureCoverPhotoByBookIdMethod = new  GetAzureCoverPhotoByBookIdMethod(IDBook);
        getAzureCoverPhotoByBookIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoByBookIdMethod.callAPI();
        getAzureCoverPhotoByBookIdMethod.validateResponseAgainstSchema("api.azure_coverPhoto\\_get\\rs.schema");
    }

}

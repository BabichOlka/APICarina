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
import com.solvd.automation.lab.carina.demo.api.azure.author.*;
import com.solvd.automation.lab.carina.demo.api.azure.books.*;
import com.solvd.automation.lab.carina.demo.bo.AzureAuthor;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class APITestAuthor {

    private static final Logger LOGGER = Logger.getLogger(APITestAuthor.class);


    @MethodOwner(owner = "babich")
    @Test
    public void testCreateAzureAuthor() throws Exception{

         String IDBook = "1";
         String firstName="First";
         String lastName= "Last";

        AzureAuthor azureAuthor = new AzureAuthor(IDBook,firstName,lastName);

        PostAzureAuthorMethod postAzureAuthorMethod = new PostAzureAuthorMethod(azureAuthor);
        postAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureAuthorMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureAuthor actualAuthor = mapper.readValue(rs, AzureAuthor.class);

        Assert.assertNotNull(actualAuthor, "Response object cannot be null!");
        Assert.assertEquals(actualAuthor.getIDBook(), azureAuthor.getIDBook(), "IDBook is not as expected!");
        Assert.assertEquals(actualAuthor.getFirstName(), azureAuthor.getFirstName(), "FirstName is not as expected!");
        Assert.assertEquals(actualAuthor.getLastName(), azureAuthor.getLastName(), "LastName is not as expected!");


    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureAuthor() throws Exception{

        GetAzureAuthorMethod getAzureAuthorMethod = new  GetAzureAuthorMethod();
        getAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorMethod.callAPI();

       getAzureAuthorMethod.validateResponseAgainstSchema("api.azure_author\\_get\\rs.schema");
    }

    @MethodOwner(owner = "babich")
    @Test
    public void testDeleteAzureAuthor() throws Exception{
        int id = 1;
        DeleteAzureAuthorByIdMethod deleteAzureAuthorMethod = new  DeleteAzureAuthorByIdMethod(id);
        deleteAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureAuthorMethod.callAPI();

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureAuthorById() throws Exception{
        int id = 1;
        AzureAuthor azureAuthor = new AzureAuthor();
        azureAuthor.setId(String.valueOf(id));

        GetAzureAuthorByIdMethod getAzureAuthorMethod = new  GetAzureAuthorByIdMethod(azureAuthor);
        getAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorMethod.callAPI();

        String rs = getAzureAuthorMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureAuthor actualAuthor = mapper.readValue(rs, AzureAuthor.class);

        Assert.assertNotNull(actualAuthor, "Response object cannot be null!");
        Assert.assertEquals(actualAuthor.getId(), azureAuthor.getId(), "Id is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testPutAzureAuthorById() throws Exception{
        String id = String.valueOf(1);
        String IDBook = "1";
        String firstName="First";
        String lastName= "Last";

        AzureAuthor azureAuthor = new AzureAuthor(id,IDBook,firstName,lastName);

        PutAzureAuthorByIdMethod putAzureAuthorMethod = new PutAzureAuthorByIdMethod(azureAuthor);
        putAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureAuthorMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureAuthor actualAuthor = mapper.readValue(rs, AzureAuthor.class);


        Assert.assertNotNull(actualAuthor, "Response object cannot be null!");
        Assert.assertEquals(actualAuthor.getIDBook(), azureAuthor.getIDBook(), "IDBook is not as expected!");
        Assert.assertEquals(actualAuthor.getFirstName(), azureAuthor.getFirstName(), "FirstName is not as expected!");
        Assert.assertEquals(actualAuthor.getLastName(), azureAuthor.getLastName(), "LastName is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureAuthorByBookId() throws Exception{
        int IDBook = 1;
        AzureAuthor azureAuthor = new AzureAuthor();
        azureAuthor.setId(String.valueOf(IDBook));

        GetAzureAuthorByBookIdMethod getAzureAuthorByBookIdMethod = new  GetAzureAuthorByBookIdMethod(IDBook);
        getAzureAuthorByBookIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorByBookIdMethod.callAPI();
        getAzureAuthorByBookIdMethod.validateResponseAgainstSchema("api.azure_author\\_get\\rs.schema");
    }

}

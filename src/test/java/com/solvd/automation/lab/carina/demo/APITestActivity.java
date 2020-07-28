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
import com.solvd.automation.lab.carina.demo.api.azure.activity.*;
import com.solvd.automation.lab.carina.demo.api.azure.books.*;
import com.solvd.automation.lab.carina.demo.bo.AzureActivity;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class APITestActivity {

    private static final Logger LOGGER = Logger.getLogger(APITestActivity.class);


    @MethodOwner(owner = "babich")
    @Test
    public void testCreateAzureActivity() throws Exception{

        int id = 1;
        String title = "activ";
        String dueDate = LocalDateTime.now().toString();
        boolean completed = true;

        AzureActivity azureActivity = new AzureActivity(title,dueDate,completed);

        PostAzureActivityMethod postAzureActivityMethod = new PostAzureActivityMethod(azureActivity);
        postAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureActivityMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureActivity actualActivity = mapper.readValue(rs, AzureActivity.class);

        Assert.assertNotNull(actualActivity, "Response object cannot be null!");
        Assert.assertEquals(actualActivity.getTitle(), azureActivity.getTitle(), "Title is not as expected!");
        Assert.assertEquals(actualActivity.getCompleted(), azureActivity.getCompleted(), "Completed is not as expected!");
       // Assert.assertEquals(actualActivity.getDueDate(), azureActivity.getDueDate(), "DueDate is not as expected!");
        Assert.assertEquals(actualActivity.getId(), azureActivity.getId(), "Id is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureActivity() throws Exception{

        GetAzureActivityMethod getAzureActivityMethod = new  GetAzureActivityMethod();
        getAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureActivityMethod.callAPI();

       getAzureActivityMethod.validateResponseAgainstSchema("api.azure_activity\\_get\\rs.schema");
    }

    @MethodOwner(owner = "babich")
    @Test
    public void testDeleteAzureUser() throws Exception{
        int id = 1;
        DeleteAzureActivityByIdMethod deleteAzureActivityMethod = new  DeleteAzureActivityByIdMethod(id);
        deleteAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureActivityMethod.callAPI();

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureActivityById() throws Exception{
        int id = 1;
        AzureActivity azureActivity = new AzureActivity();
        azureActivity.setId(id);

        GetAzureActivityByIdMethod getAzureActivityMethod = new  GetAzureActivityByIdMethod(azureActivity);
        getAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureActivityMethod.callAPI();

        String rs = getAzureActivityMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureActivity actualActivity = mapper.readValue(rs, AzureActivity.class);

        Assert.assertNotNull(actualActivity, "Response object cannot be null!");
        Assert.assertEquals(actualActivity.getId(), azureActivity.getId(), "Id is not as expected!");


    }
    @MethodOwner(owner = "babich")
    @Test
    public void testPutAzureActivityById() throws Exception{
        int id = 1;
        String title = "activ";
        String dueDate = LocalDateTime.now().toString();
        boolean completed = true;

        AzureActivity azureActivity = new AzureActivity(id,title,dueDate,completed);


        PutAzureActivityByIdMethod putAzureActivityMethod = new PutAzureActivityByIdMethod(azureActivity);
        putAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureActivityMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureActivity actualActivity = mapper.readValue(rs, AzureActivity.class);

        Assert.assertNotNull(actualActivity, "Response object cannot be null!");
        Assert.assertEquals(actualActivity.getTitle(), azureActivity.getTitle(), "Title is not as expected!");
        Assert.assertEquals(actualActivity.getCompleted(), azureActivity.getCompleted(), "Completed is not as expected!");
       // Assert.assertEquals(actualActivity.getDueDate(), azureActivity.getDueDate(), "DueDate is not as expected!");
        Assert.assertEquals(actualActivity.getId(), azureActivity.getId(), "Id is not as expected!");

    }

}

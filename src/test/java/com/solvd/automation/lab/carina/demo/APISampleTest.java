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
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.lab.carina.demo.api.azure.user.*;
import com.solvd.automation.lab.carina.demo.bo.AzureUser;
import org.apache.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APISampleTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(APISampleTest.class);


    @MethodOwner(owner = "babich")
    @Test
    public void testCreateAzureUser() throws Exception{
        String uname = "babich";
        String pword = "root";
        PostAzureUserMethod postAzureUserMethod = new PostAzureUserMethod(uname, pword);
        postAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureUserMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureUser actualUser = mapper.readValue(rs, AzureUser.class);

        Assert.assertNotNull(actualUser, "Response object cannot be null!");
        Assert.assertEquals(actualUser.getUsername(), uname, "Username is not as expected!");
        Assert.assertEquals(actualUser.getPassword(), pword, "Password is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureUser() throws Exception{

        GetAzureUserMethod getAzureUserMethod = new  GetAzureUserMethod();
        getAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureUserMethod.callAPI();
        getAzureUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

    }

    @MethodOwner(owner = "babich")
    @Test
    public void testDeleteAzureUser() throws Exception{
        int id = 1;
        DeleteAzureUserByIdMethod deleteAzureUserMethod = new  DeleteAzureUserByIdMethod(id);
        deleteAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureUserMethod.callAPI();

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureUserById() throws Exception{
     int id = 1;
        GetAzureUserByIdMethod getAzureUserMethod = new  GetAzureUserByIdMethod(id);
        getAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureUserMethod.callAPI();
        getAzureUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testPutAzureUserById() throws Exception{
        int id = 2;
        String uname = "babich";
        String pword = "root";
        PutAzureUserByIdMethod putAzureUserMethod = new PutAzureUserByIdMethod(id,uname, pword);
        putAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureUserMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureUser actualUser = mapper.readValue(rs, AzureUser.class);

        Assert.assertNotNull(actualUser, "Response object cannot be null!");
        Assert.assertEquals(actualUser.getUsername(), uname, "Username is not as expected!");
        Assert.assertEquals(actualUser.getPassword(), pword, "Password is not as expected!");
        Assert.assertEquals(actualUser.getId(), ""+ id, "Id is not as expected!");
    }

}

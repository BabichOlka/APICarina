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
import com.solvd.automation.lab.carina.demo.api.azure.books.*;
import com.solvd.automation.lab.carina.demo.bo.AzureBooks;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class APISampleTestBooks {

    private static final Logger LOGGER = Logger.getLogger(APISampleTestBooks.class);


    @MethodOwner(owner = "babich")
    @Test
    public void testCreateAzureBooks() throws Exception{

        String title = "Title";
        String description = "Deckr";
        String pageCount = "100";
        String excerpt = "Looo";
        String publishDate = LocalDateTime.now().toString();;
        AzureBooks azureBook = new AzureBooks(title,description,pageCount,excerpt,publishDate);

        PostAzureBooksMethod postAzureBooksMethod = new PostAzureBooksMethod(azureBook);
        postAzureBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureBooksMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureBooks actualBooks = mapper.readValue(rs, AzureBooks.class);

        Assert.assertNotNull(actualBooks, "Response object cannot be null!");
        Assert.assertEquals(actualBooks.getTitle(), azureBook.getTitle(), "Title is not as expected!");
        Assert.assertEquals(actualBooks.getDescription(), azureBook.getDescription(), "Description is not as expected!");
        Assert.assertEquals(actualBooks.getPageCount(), azureBook.getPageCount(), "PageCount is not as expected!");
        Assert.assertEquals(actualBooks.getExcerpt(), azureBook.getExcerpt(), "Excerpt is not as expected!");

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureUser() throws Exception{

        GetAzureBooksMethod getAzureBooksMethod = new  GetAzureBooksMethod();
        getAzureBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureBooksMethod.callAPI();

       getAzureBooksMethod.validateResponseAgainstSchema("api.azure_books\\_get\\rs.schema");
    }

    @MethodOwner(owner = "babich")
    @Test
    public void testDeleteAzureUser() throws Exception{
        int id = 1;
        DeleteAzureBooksByIdMethod deleteAzureBooksMethod = new  DeleteAzureBooksByIdMethod(id);
        deleteAzureBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureBooksMethod.callAPI();

    }
    @MethodOwner(owner = "babich")
    @Test
    public void testGetAzureUserById() throws Exception{
        int id = 1;
        AzureBooks azureBooks = new AzureBooks();
        azureBooks.setId(String.valueOf(id));

        GetAzureBooksByIdMethod getAzureBooksMethod = new  GetAzureBooksByIdMethod(azureBooks);
        getAzureBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureBooksMethod.callAPI();

        String rs = getAzureBooksMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureBooks actualBook = mapper.readValue(rs, AzureBooks.class);

        Assert.assertNotNull(actualBook, "Response object cannot be null!");
        Assert.assertEquals(actualBook.getId(), azureBooks.getId(), "Id is not as expected!");


    }
    @MethodOwner(owner = "babich")
    @Test
    public void testPutAzureUserById() throws Exception{
        String id = String.valueOf(1);
        String title = "Title";
        String description = "Descr";
        String pageCount = "100";
        String excerpt = "Looo";
        String publishDate = LocalDateTime.now().toString();
        AzureBooks azureBook = new AzureBooks(id,title,description,pageCount,excerpt,publishDate);

        PutAzureBooksByIdMethod putAzureBooksMethod = new PutAzureBooksByIdMethod(azureBook);
        putAzureBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureBooksMethod.callAPI().asString();

        ObjectMapper mapper = new ObjectMapper();
        AzureBooks actualBooks = mapper.readValue(rs, AzureBooks.class);

        Assert.assertNotNull(actualBooks, "Response object cannot be null!");
        Assert.assertEquals(actualBooks.getTitle(), azureBook.getTitle(), "Title is not as expected!");
        Assert.assertEquals(actualBooks.getDescription(), azureBook.getDescription(), "Description is not as expected!");
        Assert.assertEquals(actualBooks.getPageCount(), azureBook.getPageCount(), "PageCount is not as expected!");
        Assert.assertEquals(actualBooks.getExcerpt(), azureBook.getExcerpt(), "Excerpt is not as expected!");

    }

}

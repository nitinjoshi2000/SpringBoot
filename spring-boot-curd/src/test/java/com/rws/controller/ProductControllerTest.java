package com.rws.controller;


import com.rws.entity.Product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
//@ContextConfiguration("/applicationContext.xml")
class ProductControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    void findAllProducts() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/products");
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals("Bike",result.getResponse().getContentAsString());
//    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/test.sql")
    public void getProductByIdTest() {
        ResponseEntity<Product> response = testRestTemplate.getForEntity("/productById/11", Product.class);

        assertEquals(11,(response.getBody()).getId());
        assertEquals("phone",response.getBody().getName());
        assertEquals(10,response.getBody().getQuantity());
        assertEquals(2000,response.getBody().getPrice());

    }

    @Test
    public void addProduct(){
        Product product = new Product();

         product.setName("Car");
         product.setQuantity(7);
         product.setPrice(360000);

        HttpEntity<Product> request = new HttpEntity<>(product);

        ResponseEntity<Product> response = testRestTemplate.postForEntity("/addProduct", request, Product.class);

        assertNotNull(response.getBody().getId());
        assertEquals("Car",response.getBody().getName());
        assertEquals(7,response.getBody().getQuantity());
        assertEquals(360000,response.getBody().getPrice());
    }
}
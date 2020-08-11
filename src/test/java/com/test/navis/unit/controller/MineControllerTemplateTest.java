package com.test.navis.unit.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.navis.main.NavisApplication;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NavisApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@ActiveProfiles("test")
public class MineControllerTemplateTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void get_numberExplodedMine_404() throws JSONException {
  
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("/mines/getNumberMinesExploded/x/-30/y", HttpMethod.GET, entity, String.class);
      
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    public void get_numberExplodedMine_400() throws JSONException {
  
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("/mines/getNumberMinesExploded/x/-30/y/test", HttpMethod.GET, entity, String.class);
      
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    
}

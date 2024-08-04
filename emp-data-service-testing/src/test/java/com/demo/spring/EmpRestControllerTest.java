package com.demo.spring;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpRestControllerTest {



   @LocalServerPort
    int port;
    @Autowired
    TestRestTemplate template;
    
    @Test
    public void findOne() {
    	ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/find/100", String.class);
        Assertions.assertTrue(response.getBody().contains("John"));
    }
    
    @Test
    public void findOneFailure() {
    	ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/find/1899", String.class);
        Assertions.assertTrue(response.getStatusCodeValue()==404);
    	
    }
    
    
    
    



  
}
package com.demo.spring.controllers;





import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.demo.spring.util.Message;



@RestController
public class BasicController {
    
    @RequestMapping(path="/message",method = RequestMethod.GET)
    public ResponseEntity<Message> display(){
        return ResponseEntity.ok(new Message("Hello There!"));
    }
    
    @RequestMapping(path="/message1",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> display1(){
        return ResponseEntity.ok(new Message("Hello There!"));
    }



}
package com.miniproject.demo.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.demo.Models.Matchdata;

@RestController
public class MatchdataController {

    @MessageMapping("/matchdata")
    @SendTo("/topic/return-to")
    public Matchdata getContent(@RequestBody Matchdata Matchdata){
        System.out.println("Received a match data message: " + Matchdata);
        return Matchdata;
    }
}

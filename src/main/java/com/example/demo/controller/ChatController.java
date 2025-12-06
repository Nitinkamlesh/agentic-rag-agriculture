package com.example.demo.controller;

import com.example.demo.service.AgenticAgriService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final AgenticAgriService service;

    public ChatController(AgenticAgriService service) {
        this.service = service;
    }

    @PostMapping("/chat")
    public String chatClient(@RequestParam("message") String message){
        return service.chat(message);
    }
}

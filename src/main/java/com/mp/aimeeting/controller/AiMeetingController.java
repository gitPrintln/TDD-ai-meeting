package com.mp.aimeeting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mp.aimeeting.service.AiMeetingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/meetings")
public class AiMeetingController {

    private final AiMeetingService aiMeetingService;
    
    @PostMapping("")
    public void createMeeting(){
        Integer result = aiMeetingService.createMeeting();
    }
    
    @PostMapping("/test")
    public ResponseEntity<String> createMeetingTest() {
        return ResponseEntity.ok("1");
    }
    
}

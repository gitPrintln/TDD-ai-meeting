package com.mp.aimeeting.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.mp.TddAiMeetingApplication;
import com.mp.aimeeting.config.TestSecurityConfig;

@SpringBootTest(classes = { TddAiMeetingApplication.class, TestSecurityConfig.class })
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class AiMeetingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @DisplayName("회의록 생성 시 1 반환")
    void createMeeting_ReturnsOne() throws Exception {
        mockMvc.perform(post("/api/meetings/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"AI 회의록 테스트\",\"content\":\"오늘 회의내용\"}"))
        .andExpect(status().isOk())              
        .andExpect(content().string("1")); 
    }
    
}

package com.demo.langchain4j.service;

import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIAgent {

    String chat(String message);
}

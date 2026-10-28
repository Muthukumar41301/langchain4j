package com.demo.langchain4j.controller;

import com.demo.langchain4j.agents.WorkflowSupportAgent;
import com.demo.langchain4j.service.AIAgent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ai-support")
@AllArgsConstructor
public class SpringAIController {

    private final AIAgent aiAgent;
    private WorkflowSupportAgent workflowSupportAgent;

    @GetMapping
    public String callAIAgent(@RequestParam("message") String message) {
        return aiAgent.chat(message);
    }

    @GetMapping("/workflow")
    public String workflowSupport(
            @RequestParam String request) {
        return workflowSupportAgent.handle(request);
    }
}

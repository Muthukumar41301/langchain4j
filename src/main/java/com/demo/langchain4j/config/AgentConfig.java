package com.demo.langchain4j.config;

import com.demo.langchain4j.agents.OrderAgent;
import com.demo.langchain4j.agents.RefundAgent;
import com.demo.langchain4j.agents.ResponseAgent;
import com.demo.langchain4j.agents.WorkflowSupportAgent;
import com.demo.langchain4j.tool.OrderTool;
import com.demo.langchain4j.tool.RefundTool;
import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgentConfig {

    @Bean
    public OrderAgent orderAgent(
            ChatModel chatModel,
            OrderTool orderTools) {

        return AgenticServices
                .agentBuilder(OrderAgent.class)
                .chatModel(chatModel)
                .tools(orderTools)
                .outputKey("orderDetails")
                .build();
    }

    @Bean
    public RefundAgent refundAgent(
            ChatModel chatModel,
            RefundTool refundTool) {

        return AgenticServices
                .agentBuilder(RefundAgent.class)
                .chatModel(chatModel)
                .tools(refundTool)
                .outputKey("refundDecision")
                .build();
    }

    @Bean
    public ResponseAgent responseAgent(
            ChatModel chatModel) {

        return AgenticServices
                .agentBuilder(ResponseAgent.class)
                .chatModel(chatModel)
                .outputKey("finalResponse")
                .build();
    }

    @Bean
    public WorkflowSupportAgent workflowSupportAgent(OrderAgent orderAgent,
                                                     RefundAgent refundAgent,
                                                     ResponseAgent responseAgent) {
        return AgenticServices
                .sequenceBuilder(WorkflowSupportAgent.class)
                .subAgents(orderAgent, refundAgent, responseAgent)
                .outputKey("finalResponse")
                .build();

    }
}

# LangChain4j Multi-Agent AI Implementation in Spring Boot

## Overview

This project demonstrates a Multi-Agent AI system using LangChain4j and Spring Boot. Multiple specialized AI agents collaborate to process user requests, retrieve information, execute business logic, and generate context-aware responses.

## Technologies Used

- Java 25
- Spring Boot 4
- LangChain4j
- Large Language Models (LLMs)
- MySQL
- Maven
- REST APIs

## Architecture

### 1. LangChain4j AI Agent Workflow

This diagram illustrates how the application communicates with an AI agent, LangChain4j, and an LLM. The LLM can request tool execution when additional information or business logic is required.

<img width="1045" height="587" alt="Langchain4j" src="https://github.com/user-attachments/assets/ba7b080e-585e-4c2b-9b14-d086f25f1728" />


### 2. Multi-Agent Order and Refund Processing

This workflow demonstrates how specialized agents collaborate to process order details and determine refund eligibility.

<img width="1048" height="582" alt="Langchain4j-v1" src="https://github.com/user-attachments/assets/49547145-10a7-4245-87b7-0a98f43d7e42" />


### Workflow Components

- **OrderAgent:** Retrieves order details using the Order Tool.
- **Order Tool:** Fetches order information from the database.
- **RefundAgent:** Evaluates refund eligibility using refund policies.
- **Refund Tool:** Retrieves the applicable refund policy.
- **ResponseAgent:** Combines the results and generates the final response.
- **AgenticScope:** Maintains shared workflow data, including the user request, order details, refund decision, and final response.

## Features

### Multi-Agent AI Architecture
- Multiple specialized AI agents.
- Separation of agent responsibilities.
- Agent coordination and task delegation.
- Shared workflow context.

### AI Agent Integration
- LangChain4j AI Services.
- Prompt engineering and system messages.
- LLM tool calling.
- Context-aware response generation.

### Order Management
- Retrieve order details.
- Check order status and payment information.
- Access order data through database-backed tools.

### Refund Processing
- Evaluate refund eligibility based on order status.
- Retrieve refund policies.
- Generate customer-friendly refund decisions.

### Spring Boot Integration
- REST API endpoints.
- Dependency injection.
- Centralized exception handling.
- Database integration.

## Example Use Case

**User Request:**

"Check the delivery status of order ORD1001 and determine whether it is eligible for a refund."

**Processing Flow:**

1. The application receives the user request.
2. The OrderAgent invokes the Order Tool.
3. The tool retrieves order details from MySQL.
4. The RefundAgent evaluates the applicable refund policy.
5. The ResponseAgent generates a consolidated response.
6. The application returns the final response to the user.

## Database Tables

### order_detail

Stores order information such as order ID, customer name, product name, order status, delivery location, expected delivery date, total amount, and payment status.

### refund_policy

Stores refund rules, eligibility information, and customer-facing messages for different order statuses.

## Getting Started

### Prerequisites

- Java 25 or a compatible JDK for your configured project
- Maven
- MySQL
- A supported LLM provider, such as Ollama or a cloud model

### Setup

1. Clone the repository.
2. Configure the database connection.
3. Configure the LLM provider and model.
4. Create the required database tables.
5. Build and run the Spring Boot application.
6. Send a request to the configured REST API endpoint.

## Learning Objectives

- Implement multi-agent AI workflows using LangChain4j.
- Integrate LLMs with Spring Boot applications.
- Use tools to execute Java business logic.
- Share data between agents using workflow context.
- Build database-backed AI assistants.
- Apply AI orchestration to real-world order and refund scenarios.

## References

- [LangChain4j Documentation](https://docs.langchain4j.dev/)
- [LangChain4j GitHub Repository](https://github.com/langchain4j/langchain4j)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/index.html)

## Author

Java Backend Developer | Spring Boot | LangChain4j | Multi-Agent AI

🌾 Agentic RAG Agriculture Assistant — Spring Boot + Spring AI + Qdrant

A prototype Agentic RAG (Retrieval-Augmented Generation) system built using Spring Boot, Spring AI, and Qdrant Vector Database.
This project demonstrates how multiple AI agents (Query Rewriter, RAG Retriever, Answer Generator, Critic Agent) work together to produce accurate agriculture-focused answers.

This prototype is fully customizable — you can add your own datasets, agents, workflows, tools, and domain logic.

🚀 Features

✅ Agentic RAG Pipeline (multi-agent system)
✅ Query Rewriter Agent – improves user query
✅ Qdrant Vector Store – semantic retrieval
✅ Answer Generator Agent
✅ Critic Agent – validates and improves answers
✅ Spring Boot REST API
✅ Embeddings using OpenAI
✅ Pluggable architecture → Add your own tools and agents easily
✅ Simple and clean code for learning GenAI engineering concepts

🧠 How Agentic RAG Works in This Project
User Query → Query Rewriter Agent → Embedding Search (Qdrant)
→ RAG Context → Answer Generator Agent → Critic Agent → Final Answer

Agents Included
Agent	Purpose
🔍 Query Rewriter	Cleans & optimizes the user query
📚 Retriever (RAG)	Searches relevant chunks from Qdrant
🤖 Answer Generator	Creates accurate agriculture advice
🧠 Critic Agent	Reviews and improves final output
📁 Project Structure
src/
 ├── main/java/com/example/demo/
 │    ├── config/
 │    │     ├── ChatClientConfig.java
 │    │     ├── EmbeddingConfig.java
 │    │     ├── AgriVectorStoreConfig.java
 │    ├── controller/
 │    │     └── ChatController.java
 │    ├── service/
 │    │     └── AgenticAgriService.java
 │    └── DemoApplication.java
 │
 ├── main/resources/
 │    ├── agri-data/
 │    │     ├── soil.txt
 │    │     ├── wheat.txt
 │    │     └── pests.txt
 │    ├── application.properties
 │
 └── test/java/...

⚙️ Tech Stack

Java 21
Spring Boot 3
Spring AI
OpenAI GPT model
Qdrant Vector Database
Docker (optional)

📦 Setup Instructions
1. Clone the Repository
git clone https://github.com/your-username/agentic-rag-agriculture.git
cd agentic-rag-agriculture

2. Add Your OpenAI Key (without committing it)

Create a file:
.env

Add:
OPENAI_API_KEY=your_key_here


Your application.properties should contain:
spring.ai.openai.api-key=${OPENAI_API_KEY}

3. Start Qdrant
Option A — Docker:
docker run -p 6334:6334 qdrant/qdrant

Option B — Qdrant Cloud (free)

5. Run the Spring Boot App
mvn spring-boot:run

🧪 Testing the API (Postman / Curl)
POST request:
POST http://localhost:8080/api/chat


Body → form-data:

key	value
message	Why wheat leaves turn yellow?
Example Response:
Wheat leaves may turn yellow due to nutrient deficiency or aphid attack.
Use neem oil spray and monitor soil moisture.

📚 Customizing the Dataset

Add your domain documents to:

src/main/resources/agri-data/


Documents are automatically:
Chunked
Embedded
Stored in Qdrant

🛠️ Future Enhancements
🌱 Multi-agent planning (ReAct or tool-use agent)
🚜 Image-based plant disease diagnosis
🌩 Real-time weather data retrieval agent
📈 Yield prediction agent
📡 IoT integration
🤝 Contributions

Contributions, ideas, and improvements are welcome!
Feel free to open PRs, issues, or discussions.

📄 License
This project is open-source under the MIT License.

⭐ Support
If you like this project, give it a ⭐ on GitHub — it motivates further development!

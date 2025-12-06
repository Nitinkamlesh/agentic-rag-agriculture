🌾 Agentic RAG Agriculture Assistant
Spring Boot + Spring AI + Qdrant (Vector DB)
<p align="center"> <img src="YOUR_LOGO_URL_HERE" width="140" /> </p> <p align="center"> 🚀 A modern multi-agent RAG system designed for Agriculture-focused Question Answering </p>
🛠 Tech Stack
<p> <img src="https://img.shields.io/badge/Java-21-blue" /> <img src="https://img.shields.io/badge/Spring%20Boot-3.4-green" /> <img src="https://img.shields.io/badge/Spring%20AI-1.0-orange" /> <img src="https://img.shields.io/badge/Qdrant-Vector%20DB-red" /> <img src="https://img.shields.io/badge/OpenAI-Embeddings-lightgrey" /> </p>
📌 Project Overview

This project is a prototype Agentic RAG (Retrieval-Augmented Generation) system for the agriculture domain built using:

Spring Boot (REST API backend)

Spring AI (LLM orchestration + agents)

Qdrant Vector Database (semantic embeddings search)

It contains multiple intelligent agents working together:

Agent	Role
🔍 Query Rewriter Agent	Cleans, clarifies, improves user query
📚 RAG Retrieval Agent	Searches most relevant agriculture knowledge
🤖 Answer Generation Agent	Creates precise agricultural advice
🧠 Critic Agent	Verifies, corrects & enhances final answer

This pipeline ensures high accuracy, domain-specific responses, and better reliability than basic RAG.

🧠 Agentic RAG Architecture
<p align="center"> <img src="YOUR_DIAGRAM_URL_HERE" width="600"/> </p>
Flow
User Input
     ↓
Query Rewriter Agent
     ↓
Vector DB Search (Qdrant)
     ↓
Answer Generation Agent
     ↓
Critic / Verification Agent
     ↓
Final Answer

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
 └── test/

⚙️ Setup Guide
1️⃣ Clone the Repository
git clone https://github.com/your-username/agentic-rag-agriculture.git
cd agentic-rag-agriculture

2️⃣ Configure Environment Variables

Create .env file:

OPENAI_API_KEY=your_api_key_here


Update application.properties:

spring.ai.openai.api-key=${OPENAI_API_KEY}


✔ Never commit your real API keys.

3️⃣ Start Qdrant (Vector Database)
Option A — Docker
docker run -p 6334:6334 qdrant/qdrant

Option B — Qdrant Cloud

Free cloud instance available at:
https://cloud.qdrant.io

4️⃣ Run the Application
mvn spring-boot:run

🧪 Test the API (Postman)
POST → http://localhost:8080/api/chat

Body → Form-data:

Key	Value
message	Why are wheat leaves turning yellow?
Example Response
Wheat leaves often turn yellow due to nutrient deficiency or aphid attack.
Apply neem oil spray and check soil nitrogen levels.

📚 Customizing the Dataset

Add your documents here:

src/main/resources/agri-data/


The system automatically:

Splits documents

Generates embeddings

Stores them in Qdrant

Just restart the app.

🔮 Future Enhancements

🌱 Multi-agent planning (ReAct, Tool-Augmented AI)

📷 Plant disease detection via images

🌦 Live weather agent

📡 IoT farm sensor integration

📈 Crop yield prediction models

🤝 Contributing

Pull requests, issues, and feature ideas are welcome!

📜 License

MIT License

⭐ Support the Project

If this project helps you, please ⭐ the repo —
It motivates me to build more open-source GenAI projects!

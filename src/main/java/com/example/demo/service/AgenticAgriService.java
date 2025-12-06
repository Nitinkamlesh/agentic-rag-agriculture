package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;

@Service
public class AgenticAgriService {

    private final ChatClient llm;
    private final QdrantVectorStore vectorStore;

    public AgenticAgriService(ChatClient llm,
            QdrantVectorStore vectorStore) {
        this.llm = llm;
        this.vectorStore = vectorStore;
    }

    public String chat(String userQuery) {

        // --------  QUERY REWRITER AGENT --------
        String refinedQuery = runAgent("""
                Rewrite this query clearly for agriculture search:
                "%s"
                """.formatted(userQuery));

        log("Refined Query", refinedQuery);

        // -------- RETRIEVAL (RAG) --------
        var results = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(refinedQuery)
                        .topK(3)
                        .build()
        );

        String ragContext = results.stream()
                .map(doc -> doc.getText())
                .reduce("", (a, b) -> a + "\n" + b);

        log("RAG Context", ragContext);

        // -------- 3️⃣ ANSWER GENERATION AGENT --------
        String rawAnswer = runAgent("""
                You are an agriculture expert AI.

                Use ONLY the following context to answer:

                Context:
                %s

                User Question: %s
                """.formatted(ragContext, userQuery));
        log("Raw Answer", rawAnswer);

        // -------- 4️⃣ CRITIC / VERIFIER AGENT --------
        String finalAnswer = runAgent("""
                Review this answer for correctness & clarity.
                Improve ONLY if required:

                %s
                """.formatted(rawAnswer));

        log("Critic Final Answer", finalAnswer);
        return finalAnswer;
    }


    // -------- REUSABLE AGENT CALL FUNCTION --------
    private String runAgent(String prompt) {
        return llm.prompt()
                .user(prompt)
                .call()
                .content();
    }

    // -------- CLEAN STRUCTURED LOGGING --------
    private void log(String title, String content) {
        System.out.println("\n-------------- " + title + " --------------");
        System.out.println(content);
    }
}

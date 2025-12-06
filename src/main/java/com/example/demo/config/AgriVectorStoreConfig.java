package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.util.List;

@Configuration
public class AgriVectorStoreConfig {


    @Bean
    public Void loadDocuments(QdrantVectorStore vectorStore) throws Exception {

        List<Document> docs = List.of(
                new Document(Files.readString(new ClassPathResource("agri-data/soil.txt").getFile().toPath())),
                new Document(Files.readString(new ClassPathResource("agri-data/wheat.txt").getFile().toPath())),
                new Document(Files.readString(new ClassPathResource("agri-data/pests.txt").getFile().toPath()))
        );

        vectorStore.add(docs);

        return null;  // return void bean (no circular dependency)
    }
}

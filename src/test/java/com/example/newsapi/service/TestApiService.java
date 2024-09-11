package com.example.newsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.newsapi.model.Article;
import com.example.newsapi.model.NewsEntity;
import com.example.newsapi.model.Source;
import com.example.newsapi.repository.NewsApiRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@DataJpaTest
class TestApiService {

    @Autowired
    private NewsApiRepository newsRepository;

    public void saveNewsEntity(NewsEntity newsEntity) {
        newsRepository.save(newsEntity);
    }

    @Test
    void saveNewsEntity_ShouldSaveToRepository() {
        // Arrange
        NewsEntity sampleNews = createSampleNewsEntity();

        // Act
        saveNewsEntity(sampleNews);

        // Assert
        NewsEntity savedNews = newsRepository.findById(sampleNews.getId()).orElse(null);
        assertEquals(sampleNews, savedNews);

        // Debug log with color
        System.out.println("\u001B[32mSaved NewsEntity: " + savedNews + "\u001B[0m");

        // Pretty print the saved NewsEntity
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String prettyPrintedNewsEntity = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(savedNews);
            System.out.println("\u001B[33mSaved NewsEntity:\u001B[0m");

            // Split the JSON string by lines and prepend the escape code to each line
            String[] lines = prettyPrintedNewsEntity.split("\n");
            for (String line : lines) {
                System.out.println("\u001B[33m" + line + "\u001B[0m");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private NewsEntity createSampleNewsEntity() {
        NewsEntity sampleNews = new NewsEntity();
        sampleNews.setStatus("ok");
        sampleNews.setTotalResults(1);

        Source sampleSource = new Source();
        sampleSource.setId("sample-source-id");
        sampleSource.setName("Sample Source Name");

        Article sampleArticle = new Article();
        sampleArticle.setSource(sampleSource);
        sampleArticle.setAuthor("Sample Author");
        sampleArticle.setTitle("Sample Title");
        sampleArticle.setDescription("Sample Description");
        sampleArticle.setUrl("https://sample-url.com");
        sampleArticle.setUrlToImage("https://sample-image-url.com");
        sampleArticle.setPublishedAt(LocalDateTime.now().toString());
        sampleArticle.setContent("Sample Content");

        sampleNews.setArticles(Collections.singletonList(sampleArticle));

        return sampleNews;
    }
}

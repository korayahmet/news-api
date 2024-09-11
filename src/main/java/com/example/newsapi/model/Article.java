package com.example.newsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Article {

    @JsonProperty("source")     //todo check if JsonProperty needed
    @Embedded
    private Source source;

    @JsonProperty("author")
    @Column(name = "author")
    private String author;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("description")
    @Column(name= "description", columnDefinition = "TEXT") // Change the data type to TEXT
    private String description;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    @JsonProperty("urlToImage")
    @Column(name= "url_to_image", columnDefinition = "TEXT") // Change the data type to TEXT
    private String urlToImage;

    @JsonProperty("publishedAt")
    @Column(name = "published_at")
    private String publishedAt;

    @JsonProperty("content")
    @Column(name= "content", columnDefinition = "TEXT") // Change the data type to TEXT
    private String content;
}

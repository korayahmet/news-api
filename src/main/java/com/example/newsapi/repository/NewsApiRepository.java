package com.example.newsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsapi.model.NewsEntity;

public interface NewsApiRepository extends JpaRepository<NewsEntity, Long> {
    //todo Add custom queries if needed
}
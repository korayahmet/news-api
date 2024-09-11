package com.example.newsapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.newsapi.model.NewsEntity;
import com.example.newsapi.repository.NewsApiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NewsApiService {

    private final NewsApiRepository newsApiRepository;

    public List<NewsEntity> getAllNews() {
        return newsApiRepository.findAll();
    }
}

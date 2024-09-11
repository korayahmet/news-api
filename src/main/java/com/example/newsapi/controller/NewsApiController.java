package com.example.newsapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsapi.model.NewsEntity;
import com.example.newsapi.service.NewsApiService;

import lombok.AllArgsConstructor;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")            //Allow News UI module to reach the controller (CORS)
@AllArgsConstructor
@RequestMapping("/newsapi/news")
public class NewsApiController {

    private final NewsApiService newsApiService;

    @GetMapping
    public ResponseEntity<List<NewsEntity>> getAllNewsForApi() {
        return new ResponseEntity<List<NewsEntity>>(newsApiService.getAllNews(), OK);

        //!Alternative method
        // List<NewsEntity> newsList = newsApiService.getAllNews();
        // return ResponseEntity.ok(newsList);
    }
}

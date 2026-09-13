package com.example.rssdemo.controller;


import com.example.rssdemo.service.RssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rss")
public class RssController {

    private final RssService rssService;

    public RssController(RssService rssService) {
        this.rssService = rssService;
    }

    @PostMapping("/fetchRss")
    public String fetchRss(){
        rssService.fetchRss();

        return "success";
    }


}

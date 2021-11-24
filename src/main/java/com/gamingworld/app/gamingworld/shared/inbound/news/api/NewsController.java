package com.gamingworld.app.gamingworld.shared.inbound.news.api;

import com.gamingworld.app.gamingworld.shared.inbound.news.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(path = "", params = {"theme"})
    public String findByName(@RequestParam("theme") String theme) {
        return newsService.findByTheme(theme);
    }

    @GetMapping(path = "")
    public String findByName() {
        return newsService.findByTheme("Gaming");
    }
}

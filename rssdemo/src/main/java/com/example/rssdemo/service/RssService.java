package com.example.rssdemo.service;

import com.example.rssdemo.model.News;
import com.example.rssdemo.repository.RssRep;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import org.springframework.stereotype.Service;
import com.rometools.rome.io.XmlReader;

import java.net.URI;

@Service
public class RssService {

    private final RssRep rssRep;

    public RssService(RssRep rssRep) {
        this.rssRep = rssRep;
    }

    public void fetchRss() {

        String rssUrl = "https://example.com/rss.xml";

        try {

            SyndFeedInput input = new SyndFeedInput();

            SyndFeed feed = input.build(
                    new XmlReader(URI.create(rssUrl).toURL())
            );

            for (SyndEntry entry : feed.getEntries()) {

                String title = entry.getTitle();
                String content = entry.getDescription().getValue();
                String articleUrl = entry.getLink();

                if (isRelevant(title, content)) {

                    News news = new News(title, content, articleUrl);

                    rssRep.save(news);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isRelevant(String title, String content) {
        String text = (title + content).toLowerCase();
        return text.contains("china") || text.contains("uyghur") || text.contains("east turkistan");
    }

}

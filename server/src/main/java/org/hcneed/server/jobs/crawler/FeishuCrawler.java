package org.hcneed.server.jobs.crawler;

import lombok.extern.slf4j.Slf4j;
import org.hcneed.server.entities.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class FeishuCrawler {
    private static final Logger logger = LoggerFactory.getLogger(FeishuCrawler.class);

    @Scheduled(cron = "*/5 * * * * *")
    public void job() {
        Post post = new Post();
        post.setTitle("feishu crawler");
        post.setContent("feishu crawler");
        logger.info("feishu crawler", new Object[]{post});
    }

}

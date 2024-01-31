package org.hcneed.server.jobs.crawler;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.hcneed.server.common.crawler.FeiShuCrawler;
import org.hcneed.server.entities.models.Company;
import org.hcneed.server.entities.models.Position;
import org.hcneed.server.repositories.jpa.CompanyJPARepository;
import org.hcneed.server.repositories.jpa.PositionJPARepository;
import org.hcneed.server.utils.SessionRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Component
public class ByteDanceCrawler extends FeiShuCrawler {

    public ByteDanceCrawler() {
        this.companyName = "字节跳动";
        this.listPage = "https://jobs.bytedance.com/campus/position";
        this.sessionRequestUtil = new SessionRequestUtil();
        this.csrfUrl = "https://jobs.bytedance.com/api/v1/csrf/token";
        this.jobListUrl = "https://jobs.bytedance.com/api/v1/search/job/posts";
        this.detailUrl = "https://jobs.bytedance.com/campus/position/";
    }

//    @Scheduled(cron = "*/5 * * * * *")
    public void job() {
        synchronized (this) {
            parse();
        }
    }

}

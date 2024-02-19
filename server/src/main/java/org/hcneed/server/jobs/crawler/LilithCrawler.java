package org.hcneed.server.jobs.crawler;

import lombok.extern.slf4j.Slf4j;
import org.hcneed.server.common.crawler.FeiShuCrawler;
import org.hcneed.server.utils.SessionRequestUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LilithCrawler extends FeiShuCrawler {

    public LilithCrawler() {
        this.companyName = "莉莉丝游戏";
        this.listPage = "https://lilithgames.jobs.feishu.cn/campus/position";
        this.sessionRequestUtil = new SessionRequestUtil();
        this.csrfUrl = "https://lilithgames.jobs.feishu.cn/api/v1/csrf/token";
        this.jobListUrl = "https://lilithgames.jobs.feishu.cn/api/v1/search/job/posts";
        this.detailUrl = "https://lilithgames.jobs.feishu.cn/campus/position/";
    }

    @Override
    public String getParam() {
        return "{\"keyword\":\"\",\"limit\":10000,\"offset\":0,\"job_category_id_list\":[],\"tag_id_list\":[],\"location_code_list\":[],\"subject_id_list\":[\"7265164996803709195\"],\"recruitment_id_list\":[],\"portal_type\":6,\"job_function_id_list\":[],\"portal_entrance\":1}";
    }

//    @Scheduled(cron = "*/5 * * * * *")
    public void job() {
        synchronized (this) {
            parse();
        }
    }

}

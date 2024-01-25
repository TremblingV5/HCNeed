package org.hcneed.server.jobs.crawler.FeiShu;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.hcneed.server.common.crawler.BaseCrawler;
import org.hcneed.server.entities.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class FeishuCrawler {
    private static final Logger logger = LoggerFactory.getLogger(FeishuCrawler.class);
    private String company;
    private String listUrl;

    public FeishuCrawler() {
        this.company = "字节跳动";
        this.listUrl = "https://jobs.bytedance.com/api/v1/search/job/posts";
    }

    private String getCsrfToken() {
        String result = HttpUtil.post("https://jobs.bytedance.com/api/v1/csrf/token", new HashMap<>());
        JSONObject json = JSONUtil.parseObj(result);
        return json.getByPath("data.token", String.class);
    }

    public Map<String, Object> getParam() {
        Map<String, Object> param = new HashMap<>();
        param.put("job_category_id_list", new ArrayList<String>());
        param.put("job_function_id_list", new ArrayList<String>());
        param.put("keyword", "");
        param.put("limit", 10);
        param.put("location_code_list", new ArrayList<String>());
        param.put("offset", 10);
        param.put("portal_entrance", 1);
        param.put("portal_type", 2);
        param.put("recruitment_id_list", new ArrayList<String>());
        param.put("storefront_id_list", new ArrayList<String>());
        param.put("subject_id_list", new ArrayList<String>());
        param.put("tag_id_list", new ArrayList<String>());
        return param;
    }

    private String request() {
        String token = getCsrfToken();
        String result = HttpRequest
                .post(this.listUrl)
                .header("x-csrf-token", token)
                .form(getParam())
                .execute().body();
        return result;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void job() {
        String result = request();
        System.out.println(result);
//        JSONObject json = JSONUtil.parseObj(result);
//        System.out.println(json.get("data"));
//        logger.info("FeishuCrawler job");
    }

}

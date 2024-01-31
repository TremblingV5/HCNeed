package org.hcneed.server.common.crawler;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.hcneed.server.entities.models.Company;
import org.hcneed.server.entities.models.Position;
import org.hcneed.server.jobs.crawler.ByteDanceCrawler;
import org.hcneed.server.repositories.jpa.CompanyJPARepository;
import org.hcneed.server.repositories.jpa.PositionJPARepository;
import org.hcneed.server.utils.SessionRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Component
public class FeiShuCrawler {
    public static final Logger logger = LoggerFactory.getLogger(ByteDanceCrawler.class);
    public String companyName;
    public String listPage;
    public String csrfUrl;
    public String jobListUrl;
    public String detailUrl;

    public SessionRequestUtil sessionRequestUtil;

    @Resource
    public CompanyJPARepository companyJPARepository;
    @Resource
    public PositionJPARepository positionJPARepository;

    public FeiShuCrawler() {

    }

    public String getCsrfToken() {
        String result = sessionRequestUtil.post(this.csrfUrl, "", new HashMap<>());
        JSONObject json = JSONUtil.parseObj(result);
        return json.getByPath("data.token", String.class);
    }

    public String getParam() {
        return "{\"keyword\":\"\",\"limit\":10000,\"offset\":0,\"job_category_id_list\":[],\"tag_id_list\":[],\"location_code_list\":[],\"subject_id_list\":[],\"recruitment_id_list\":[\"201\",\"202\",\"301\"],\"portal_type\":3,\"job_function_id_list\":[],\"portal_entrance\":1}";
    }

    public ArrayList<JSONObject> getJobList(String token) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-csrf-token", token);
        String result = sessionRequestUtil.post(this.jobListUrl, getParam(), headers);
        JSONObject json = JSONUtil.parseObj(result);;
        ArrayList<JSONObject> list = json.getByPath("data.job_post_list", ArrayList.class);
        return list;
    }

    public ArrayList<JSONObject> request() {
        String token = getCsrfToken();
        ArrayList<JSONObject> result = getJobList(token);
        return result;
    }

    public void parse() {
        Company company = companyJPARepository.getCompanyByName(this.companyName);
        if (company == null) {
            company = new Company();
            company.setName(this.companyName);
            company.setUrl(this.listPage);
            companyJPARepository.save(company);
        }

        ArrayList<JSONObject> result = request();
//        ArrayList<Position> positions = new ArrayList<>();
        for (JSONObject job: result) {
            String id = job.getByPath("id", String.class);

            Position position = new Position();
            position.setTitle(job.getByPath("title", String.class));
            position.setUrl(this.detailUrl + id + "/detail");
            position.setDescription(job.getByPath("description", String.class));
            position.setCompanyId(company.getId());
            position.setLocation(job.getByPath("city_info.name", String.class));
            position.setJobCategory(job.getByPath("job_category.name", String.class));
            position.setIsActive(true);
            position.setUuid(id);
//            positions.add(position);
            try {
                positionJPARepository.save(position);
            } catch (DataIntegrityViolationException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(this.companyName + " success");
    }

}


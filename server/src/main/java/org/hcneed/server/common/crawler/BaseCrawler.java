package org.hcneed.server.common.crawler;

import java.net.HttpURLConnection;
import java.util.Map;

public abstract class BaseCrawler<T> {
    public Map<String, String> headers;
    public String url;

    public BaseCrawler() {
        headers.put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    }

    public void job() {

    }
}

package org.hcneed.server.utils;

import okhttp3.*;
import okhttp3.internal.http2.Header;
import org.springframework.http.RequestEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SessionRequestUtil {

    private class CookieJarManager implements CookieJar {
        private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookieStore.put(url.host(), cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url.host());
            return cookies != null ? cookies : new ArrayList<Cookie>(){};
        }

    }

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJarManager()).build();
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public String post(String url, String json, HashMap<String, String> headers){
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Headers.Builder headerBuilder = new Headers.Builder();
        for (String key: headers.keySet()) {
            String value = headers.get(key);
            headerBuilder.add(key, value);
        }
        Request request = new Request
                .Builder()
                .post(body)
                .url(url)
                .headers(headerBuilder.build())
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String respStr = response.body().string();
            return respStr;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String get(String url)  {
        final Request.Builder builder = new Request.Builder();
        builder.url(url);
        final Request request = builder.build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}

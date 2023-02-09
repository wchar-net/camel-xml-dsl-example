package net.wchar.camel.sample.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HttpClientComponentController {

    @Data
    @Builder
    public static class TestHttpClientModel {
        private String uuid;
        private String userName;
        private Integer userAge;

        public static List<TestHttpClientModel> create() {
            List<TestHttpClientModel> models = new ArrayList<>();
            models.add(TestHttpClientModel.builder().userAge(10).userName("张三").build());
            models.add(TestHttpClientModel.builder().userAge(30).userName("李四").build());
            models.add(TestHttpClientModel.builder().userAge(20).userName("王五").build());
            return models;
        }
    }

    @PostMapping("/testHttpClient")
    public Map<String, Object> testHttpClient(@RequestBody String bodyStr,
                                              String id,
                                              String order) {
        System.out.println(order + "\t" + id);
        return new HashMap<String, Object>() {{
            put("code", "1");
            put("message", "请求完成");
            put("data", TestHttpClientModel.create());
        }};
    }
}

package net.wchar.camel.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wchar.net
 */
@RestController
public class Demo03Controller {
    @GetMapping("/demo03")
    @ResponseBody
    public Map<String, Object> demo03(
            String paramName,
            Integer paramAge,
            @RequestHeader("headerKey") String headerKey
    ) {
        System.out.println("paramName: " + paramName);
        System.out.println("paramAge: " + paramAge);
        System.out.println("headerKey: " + headerKey);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "1");
        resultMap.put("message", "请求完成!");
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>() {{
            add(
                    new HashMap<String, Object>() {{
                        put("resultName", "No.1 这是服务器返回的哦: " + paramName);
                        put("resultAge", "No.1 这是服务器返回的哦: " + paramAge);
                        put("resultHeaderKey", "No.1 这是服务器返回的哦: " + headerKey);
                    }}
            );
            add(
                    new HashMap<String, Object>() {{
                        put("resultName", "No.2 这是服务器返回的哦: " + paramName);
                        put("resultAge", "No.2 这是服务器返回的哦: " + paramAge);
                        put("resultHeaderKey", "No.2 这是服务器返回的哦: " + headerKey);
                    }}
            );
            add(
                    new HashMap<String, Object>() {{
                        put("resultName", "No.1 这是服务器返回的哦: " + paramName);
                        put("resultAge", "No.1 这是服务器返回的哦: " + paramAge);
                        put("resultHeaderKey", "No.1 这是服务器返回的哦: " + headerKey);
                    }}
            );
        }};
        resultMap.put("data", data);
        return resultMap;
    }

}

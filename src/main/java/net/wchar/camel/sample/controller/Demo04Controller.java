package net.wchar.camel.sample.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wchar.net
 */
@RestController
public class Demo04Controller {

    @Data
    @Builder
    public static class Demo04Domain {
        private String result1;
        private String result2;
        private String result3;
    }

    @GetMapping("/demo04")
    public Demo04Domain demo04(Long id) {
        Assert.notNull(id, "id不能为空!");
        return Demo04Domain.builder().result1(id + "哈哈").result2(id + "你好啊").result3(id + "are you ok?").build();
    }
}

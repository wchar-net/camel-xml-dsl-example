package net.wchar.camel.sample.controller;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wchar.net
 */
@RestController
public class Demo02Controller {

    @Data
    @ToString
    public static class Demo02Domain {
        private String userName;
        private String userAddress;
    }

    @PostMapping("/demo02")
    public String demo02(
            @RequestHeader("api-key") String apiKey,
            @RequestBody List<Demo02Domain>domain
    ) {
        System.out.println("Demo02Controller: " + apiKey);
        System.out.println("Demo02Controller: " + domain);
        return "okay!";
    }
}

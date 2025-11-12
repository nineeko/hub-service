package org.spartahub.hubservice.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@EnableConfigurationProperties(TestProperties.class)
public class TestController {
    private final TestProperties properties;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/test1")
    public String test1() {
        return """
                test1:%s,
                test2:%s
                """.formatted(properties.getTest1(), properties.getTest2());
    }

    @GetMapping("test3")
    public String test3() {
        return "%s:%s".formatted(appName, serverPort);
    }

    @GetMapping("test4/{id}")
    public String test4(
            @PathVariable("id") String id, @RequestParam(name = "num", required = false) Integer num
    ){
        return "%s, %s".formatted(id, num);
    }

    @PostMapping("test5")
    public String test5(@RequestHeader(name="test-header1", required = false) String h1,
                        @RequestHeader(name="test-header2", required = false) String h2
    ){
        return "%s, %s".formatted(h1, h2);
    }
}

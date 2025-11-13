package org.spartahub.hubservice.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequiredArgsConstructor
public class Test2Controller {

    @Value("${message3}")
    private String message3;

    private final RemoteService remoteService;

    @GetMapping("test2")
    public String test() {
        return message3;
    }

    @GetMapping("test6/{num}")
    public String test6(@PathVariable("num") int num) {
        return remoteService.process(num);
    }
}

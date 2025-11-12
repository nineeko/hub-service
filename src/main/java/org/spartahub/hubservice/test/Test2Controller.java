package org.spartahub.hubservice.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Test2Controller {

    @Value("${message3}")
    private String message3;

    @GetMapping("/test2")
    public String test(){
        return message3;
    }
}

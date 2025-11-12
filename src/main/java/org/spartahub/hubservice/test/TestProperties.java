package org.spartahub.hubservice.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "message")
public class TestProperties {
    private String test1;
    private String test2;
}

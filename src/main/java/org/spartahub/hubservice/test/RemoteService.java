package org.spartahub.hubservice.test;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RemoteService {
    @CircuitBreaker(name="remote-service", fallbackMethod = "remoteServiceFallback")
    public String process(int num) {
        if (num == 3) {
            throw new RuntimeException("원격 요청 실패!");
        }

        return "처리 성공:" + num;
    }

    public String remoteServiceFallback(int num, Throwable e) {
        log.error("fallback", e);
        return "대체 처리: " + num;
    }
}

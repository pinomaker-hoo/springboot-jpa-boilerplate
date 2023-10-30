package boilerplate.pinomaker.global.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PushScheduling {
    @Scheduled(cron = "* 0 * * * ?", zone = "Asia/Seoul")
    public void scheduleTaskUsingCronExpression() {
        long now = System.currentTimeMillis() / 1000;
        log.info("schedule tasks using cron jobs - {}", now);
    }
}

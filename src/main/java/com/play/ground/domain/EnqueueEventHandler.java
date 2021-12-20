package com.play.ground.domain;

import com.play.ground.domain.common.SearchDataEnqueueEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EnqueueEventHandler {

    @Async
    @EventListener
    public void listen(SearchDataEnqueueEvent enqueueEvent) {
        log.info("ShopEnqueueEventHandler");
        log.info("event: {}", enqueueEvent);
        new Process(enqueueEvent)
                .enqueue();
    }
}

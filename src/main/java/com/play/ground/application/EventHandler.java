package com.play.ground.application;


import com.play.ground.config.EnqueueEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EventHandler {

    @EventListener
    public void listen(EnqueueEvent event) {
        log.info("==EventHandler==");
        log.info("event type: {}", event.getType());
        log.info("event searchId: {}", event.getSearchId());
    }
}

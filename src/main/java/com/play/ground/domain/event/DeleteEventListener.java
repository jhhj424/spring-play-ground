package com.play.ground.domain.event;

import com.play.ground.config.EnqueueEvent;
import com.play.ground.config.EnqueueProcessType;
import com.play.ground.domain.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeleteEventListener implements PostDeleteEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        log.info("==DeleteEventListener==");
        Object entity = event.getEntity();
        log.info("{}", entity);
        if (entity instanceof Shop) {
            applicationEventPublisher.publishEvent(new EnqueueEvent(((Shop) entity).getId(), EnqueueProcessType.SHOP));
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return true;
    }
}

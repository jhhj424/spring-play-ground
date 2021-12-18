package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
public class PostUpdateEventListenerImpl implements PostUpdateEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        log.info("===PostUpdateEventListener===");
        Object entity = event.getEntity();
        if (entity instanceof EnqueueEntity) {
            applicationEventPublisher.publishEvent(((EnqueueEntity) entity).getEvent());
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return PostUpdateEventListener.super.requiresPostCommitHandling(persister);
    }
}

package com.play.ground.domain.event;

import com.play.ground.config.EnqueueEvent;
import com.play.ground.config.EnqueueProcessType;
import com.play.ground.domain.Shop;
import com.play.ground.domain.annotation.ShopTargetQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpdateEventListener implements PostUpdateEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        log.info("==UpdateEventListener==");
        Object entity = event.getEntity();
        final Class<?> theClass = entity.getClass();
        if (theClass.isAnnotationPresent(ShopTargetQueue.class)) {
            final ShopTargetQueue annotation = theClass.getAnnotation(ShopTargetQueue.class);

            log.info("annotation type: {}", annotation.type());

            applicationEventPublisher.publishEvent(new EnqueueEvent(((Shop) entity).getId(), EnqueueProcessType.SHOP));
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return true;
    }
}

package com.play.ground.domain.event;

import com.play.ground.config.EnqueueEvent;
import com.play.ground.domain.annotation.EnqueueTargetField;
import com.play.ground.domain.annotation.ShopTargetQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@RequiredArgsConstructor
@Component
public class InsertEventListener implements PostInsertEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onPostInsert(PostInsertEvent event) {
        log.info("==InsertEventListener==");
        Object entity = event.getEntity();
        final Class<?> theClass = entity.getClass();
        if (theClass.isAnnotationPresent(ShopTargetQueue.class)) {
            final ShopTargetQueue annotation = theClass.getAnnotation(ShopTargetQueue.class);

            log.info("annotation type: {}", annotation.type());

            for (Field field : theClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(EnqueueTargetField.class)) {
                    try {
                        field.setAccessible(true);
                        applicationEventPublisher.publishEvent(new EnqueueEvent((Long) field.get(entity), annotation.type()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return true;
    }
}

package com.play.ground.domain.event;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Component
public class HibernateListener {

    private final EntityManagerFactory entityManagerFactory;
    private final InsertEventListener insertEventListener;
    private final UpdateEventListener updateEventListener;
    private final DeleteEventListener deleteEventListener;

    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_COMMIT_INSERT).appendListener(insertEventListener);
        registry.getEventListenerGroup(EventType.POST_COMMIT_UPDATE).appendListener(updateEventListener);
        registry.getEventListenerGroup(EventType.POST_COMMIT_DELETE).appendListener(deleteEventListener);
    }
}

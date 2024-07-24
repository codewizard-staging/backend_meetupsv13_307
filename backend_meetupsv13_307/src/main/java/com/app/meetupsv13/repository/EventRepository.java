package com.app.meetupsv13.repository;

import com.app.meetupsv13.model.Event;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class EventRepository extends SimpleJpaRepository<Event, String> {
    private final EntityManager em;
    public EventRepository(EntityManager em) {
        super(Event.class, em);
        this.em = em;
    }
    @Override
    public List<Event> findAll() {
        return em.createNativeQuery("Select * from \"meetupsv13\".\"Event\"", Event.class).getResultList();
    }
}
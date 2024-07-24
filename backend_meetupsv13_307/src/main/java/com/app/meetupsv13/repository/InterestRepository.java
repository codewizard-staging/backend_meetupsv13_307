package com.app.meetupsv13.repository;

import com.app.meetupsv13.model.Interest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class InterestRepository extends SimpleJpaRepository<Interest, String> {
    private final EntityManager em;
    public InterestRepository(EntityManager em) {
        super(Interest.class, em);
        this.em = em;
    }
    @Override
    public List<Interest> findAll() {
        return em.createNativeQuery("Select * from \"meetupsv13\".\"Interest\"", Interest.class).getResultList();
    }
}
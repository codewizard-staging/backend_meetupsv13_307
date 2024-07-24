package com.app.meetupsv13.repository;

import com.app.meetupsv13.model.Group;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class GroupRepository extends SimpleJpaRepository<Group, String> {
    private final EntityManager em;
    public GroupRepository(EntityManager em) {
        super(Group.class, em);
        this.em = em;
    }
    @Override
    public List<Group> findAll() {
        return em.createNativeQuery("Select * from \"meetupsv13\".\"Group\"", Group.class).getResultList();
    }
}
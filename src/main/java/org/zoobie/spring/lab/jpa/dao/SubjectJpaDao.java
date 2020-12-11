package org.zoobie.spring.lab.jpa.dao;


import org.springframework.stereotype.Component;
import org.zoobie.spring.lab.jpa.model.Subject;

@Component
public class SubjectJpaDao extends JpaDaoBase<Subject, Integer> {

    @Override
    protected Class<Subject> getEntityClass() {
        return Subject.class;
    }
}

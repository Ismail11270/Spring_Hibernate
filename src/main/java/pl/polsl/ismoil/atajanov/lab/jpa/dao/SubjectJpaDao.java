package pl.polsl.ismoil.atajanov.lab.jpa.dao;


import org.springframework.stereotype.Component;
import pl.polsl.ismoil.atajanov.lab.jpa.model.Subject;

@Component
public class SubjectJpaDao extends JpaDaoBase<Subject, Integer> {

    @Override
    protected Class<Subject> getEntityClass() {
        return Subject.class;
    }
}
